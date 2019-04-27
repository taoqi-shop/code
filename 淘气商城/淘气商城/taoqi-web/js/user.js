function getUser() {
    let str=sessionStorage.getItem("taoqi_user_session");
    if(str!=null)
    {
        return JSON.parse(str);
    }
    let jwt= localStorage.getItem("taoqi_jwt")
    if(jwt!=null)
    {
        let data = 'jwt=' + jwt;
        let opts = {
            method:"POST",
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body:data
        }
        fetch("http://127.0.0.1:8080/api-auth/auth/check",opts)
            .then(response => response.json())
            .then(data=>
            {
                if(data.code==200)
                {
                    localStorage.setItem("taoqi_jwt",data.msg)
                    return data.data
                }else
                {
                    return null
                }
            })
    }
    return null
}

function setUser(user) {
    sessionStorage.setItem("taoqi_user_session",JSON.stringify(user))
}
