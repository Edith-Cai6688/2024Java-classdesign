import {createRouter,createWebHashHistory}from "vue-router";
import login from "@/views/Login.vue"
import main from "@/views/Main.vue"


const routes=[
    {
        path:"/",redirect:"/login"
    },
    {
        path:"/login",component:login
    },
    {
        path:"/home",component:main
    }
]

const router=createRouter(
    {
        routes,
        history:createWebHashHistory()
    }
)
export default router;