# spring-security users on database (Postgresql)

This is a spring boot project with spring security that store user information and roles in a database
To add new role:

    Send post request to the endpoint '/roles' with the following body: 
    {
        "name":"roles_name" 
    }

To get all available roles:

    Send get request to the endpoint '/roles'.

To add new User: 

    Send post request to the endpoint '/user' with the following body: 
    {
        "username": "username",
        "password": "password",
        "roles" : [
                    {
                        "id": "role id",
                        "name": "role name"
                    }
                ]
    }