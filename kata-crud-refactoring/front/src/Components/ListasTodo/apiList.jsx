const HOST_API = "http://localhost:8080/api/"
export default{
    findAll: async () =>{
        return fetch(HOST_API+ "lists").catch(error => console.error("Error: ", error))
    },
    save: async (request) =>{
        return fetch(HOST_API+ "list",{
            method:"POST",
            body:JSON.stringify(request),
            headers:{
                'Content-Type': 'application/json'
            }
        }).catch(error => console.error("Error: ", error))
    },
    delete: async (idList) =>{
        return fetch(HOST_API+ "delList/"+ idList,{
            method:"DELETE",
            headers:{
                "Content_Type": "application/json"
            }
        }).catch(error => console.error("Error: ", error)) 
    }
};