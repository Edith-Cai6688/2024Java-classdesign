import requests from './request.js'

export const login=(data)=>{
    return requests({
        method:'post',
        url:'login',
        data
    });
};

export const listRecord = () => {
    return request({
        method: "GET",
        url: "/admin/record/listRecord",
        headers: { "X-Token": localStorage.getItem("X-Token") },
    });
};
