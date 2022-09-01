import React from 'react';
import NavBar from './NavBar';
import '../styles/Home.css';


const Home: React.FC<{}> = () => {

    return (
        <div className='bg-student-illustration bg-cover h-screen text-slate-700 font-bold'>
            <NavBar />
            <div className="p-20">
                <p className="text-4xl font-extrabold bg-clip-text text-transparent bg-gradient-to-r from-yellow-600/75 to-white min-w-min">
                    HEI Student Clubs
                </p>
                <p className="ml-4 bg-clip-text text-transparent bg-gradient-to-r from-slate-700 to-white text-2xl my-10">
                    You can join or look at the different student clubs at HEI
                </p>
                <button className='ml-4 bg-slate-100 text-xl p-2 rounded-lg border border-4 border-slate-300/75 hover:bg-yellow-600/75 hover:text-white'>
                    See more
                </button>
            </div>
        </div>
    )
}

export default Home;
