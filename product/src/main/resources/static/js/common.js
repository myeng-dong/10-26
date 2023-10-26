const ajax = {


    get : async url => {const option = {
    method : 'GET',
    headers : {Accept : 'application/json'},
    };
    try {
        const response = await fetch(url,option);
        const data = await response.json();
        return data;
    } catch(err){
        console.error(err.message);
     }
    },


    post : async (url,payload) => {const option = {
    method : 'POST',
    headers : {Accept : 'application/json','Content-Type' : 'application/json'},
    body : JSON.stringify(payload),};
    try {
        const response = await fetch(url,option);
        const data = await response.json();
        return data;
    } catch(err){
        console.log(err.message);
      }
    },


    patch : async (url,payload) => {const option = {
    method : 'PATCH',
    headers : {Accept : 'application/json', 'Content-Type' : 'application/json'},
    body : JSON.stringify(payload),
    };
    try {
        const response = await fetch(url,option);
        const data = await response.json();
        return data;
    } catch(err){
        console.lon(err.message);
      }
    },

    delete : async url => {const option = {
    method : 'DELETE',
    headers: {Accept : 'application/json'},
    };
    try{
        const response = await fetch(url,option);
        const data = await response.json();
        return data;
    } catch(err){
        console.log(err.message);
    }
    },
};

export {ajax}