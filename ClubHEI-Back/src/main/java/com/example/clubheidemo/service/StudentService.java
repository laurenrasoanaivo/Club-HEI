package com.example.clubheidemo.service;

import com.example.clubheidemo.model.Club;
import com.example.clubheidemo.model.Groups;
import com.example.clubheidemo.model.Student;
import com.example.clubheidemo.repository.ClubRepository;
import com.example.clubheidemo.repository.GroupsRepository;
import com.example.clubheidemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private GroupsRepository groupsRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> getMembers(String club_name, ClubRepository clubRepository){
        if(club_name==null){
            return findMembers();
        } else {
            return getByClubName(club_name, clubRepository);
        }
    }

    public List<Student> getAll(String first_name, String groups_name) {
        if (first_name == null && groups_name == null) {
            return studentRepository.findAll();
        } else if (groups_name != null && first_name == null) {
            return studentRepository.getByGroupsName(groups_name);
        }
        return findWhereFirstNameLike(first_name);
    }

    public Student saveStudent(Student student, Long groupsId, Long clubId, ClubRepository clubRepository,
            GroupsRepository groupsRepository, ClubService clubService, GroupsService groupsService) {
        Optional<Groups> groups = groupsRepository.findById(groupsId);
        if (groups.isPresent() && clubId != null) {
            Optional<Club> club = clubRepository.findById(clubId);
            if (club.isPresent()) {
                student.setGroups(groupsService.getById(groupsId));
                student.setClub(clubService.getById(clubId));
                studentRepository.save(student);
                return student;
            } else {
                throw new RuntimeException("Resource Not Found");
            }
        } else if (groups.isPresent() && clubId == null) {
            student.setGroups(groupsService.getById(groupsId));
            studentRepository.save(student);
            return student;
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public Optional<Student> findByRef(String ref) {
        return studentRepository.findByRef(ref);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public Student getByRef(String Ref) {
        Optional<Student> student = findByRef(Ref);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public Student getByFirstName(String first_name) {
        Optional<Student> student = studentRepository.findByFirstName(first_name);
        if (student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("Resource Not Found");
    }

    public List<Student> getByClubName(String club_name, ClubRepository clubRepository) {
        List<Student> studentsAll = findAll();
        Club club = clubRepository.getByName(club_name);
        List<Student> students = new ArrayList<>();
        for (Student s : studentsAll) {
            if(s.getClub()==club)
                students.add(s);
        }
        return students;
    }

    /*public List<Student> getByClubName(String club_name) {
        List<Student> students = studentRepository.findByClub(clubRepository.getByName(club_name));
        if (!students.isEmpty()) {
            return students;
        }
        throw new RuntimeException("Resource Not Found");
    }*/

    public List<Student> getByGroupsName(String groups_name) {
        List<Student> students = studentRepository.findByGroups(groupsRepository.getByName(groups_name));
        if (!students.isEmpty()) {
            return students;
        }
        throw new RuntimeException("Resource Not Found");
    }

    public List<Student> findWhereFirstNameLike(String query) {
        return studentRepository.findByFirstNameContaining(query);
    }

    public Student updateStudent(Long id, Long groupsId, Long clubId, ClubService clubService,
            GroupsService groupsService) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            if (groupsId != null && clubId == null) {
                student.get().setGroups(groupsService.getById(groupsId));
                return student.get();
            } else if (groupsId == null && clubId != null) {
                student.get().setClub(clubService.getById(clubId));
                return student.get();
            } else {
                student.get().setGroups(groupsService.getById(groupsId));
                student.get().setClub(clubService.getById(clubId));
                return student.get();
            }
        } else {
            throw new RuntimeException("Resource Not Found");
        }
    }

    public List<Student> findMembers(){
        List<Student> students = new ArrayList<>();
        List<Student> studentsAll = findAll();
        for (Student s : studentsAll) {
            if(s.getClub()!=null)
                students.add(s);
        }
        return students;
    }

}
