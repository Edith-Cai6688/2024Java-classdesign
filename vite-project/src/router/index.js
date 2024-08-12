import {createRouter,createWebHashHistory}from "vue-router";
import login from "@/views/Login.vue"
import home from "@/views/Home.vue"
import component from "element-plus/es/components/tree-select/src/tree-select-option.mjs";
import note from "@/components/note.vue"
import main from "@/components/main.vue"
import college from "@/components/college.vue"
import major from "@/components/major.vue"
import classer from "@/components/classer.vue"
import course from "@/components/course.vue"
import mycourse from "@/components/mycourse.vue"
import grade from "@/components/grade.vue"
import "@/components/CommonHeader.vue"
import Course from "../components/course.vue";
const routes=[
    {
        path:"/",redirect:"/login"
    },
    {
        path:"/login",component:login
    },
    {
        path:"/home",component:home,
        children:[
            {
                path:'',
                component:main
            },
            {
                path:"/note",
                name:"教务通知",
                component:note,
            },
            {
                path:"/college",
                name:"学院信息",
                component:college,
            },
            {
                path:"/major",
                name:"专业信息",
                component:major
            },
            {
                path:"/class",
                name:"班级信息",
                component:classer
            },
            {
                path:"/course",
                name:"选课中心",
                component:course
            },
            {
                path:"/mycourse",
                name:"我的选课",
                component:mycourse
            },
            {
                path:"/grade",
                name:"我的成绩",
                component:grade
            }
        ]
    },
    
        
        
    
            
        

]

const router=createRouter(
    {
        routes,
        history:createWebHashHistory()
    }
)

router.beforeEach((to,from,next)=>{
    if(to.path==='/login')return next();
    const token =window.localStorage.getItem("token");
    if(!token) return next('/login');
    next();
})
export default router;