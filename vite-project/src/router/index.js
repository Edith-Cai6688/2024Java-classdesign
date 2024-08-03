import {createRouter,createWebHashHistory}from "vue-router";
import login from "@/views/Login.vue"
import home from "@/views/Home.vue"
import component from "element-plus/es/components/tree-select/src/tree-select-option.mjs";
import note from "@/components/note.vue"
import exam from "@/components/exam.vue"
import room from "@/components/room.vue"
import main from "@/components/main.vue"
import "@/components/CommonHeader.vue"
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
                path:"/exam",
                name:"考试安排",
                component:exam
            },
            {
                path:"/room",
                name:"教室安排",
                component:room
            },
        ]
    },
    
        
        
    
            
        

]

const router=createRouter(
    {
        routes,
        history:createWebHashHistory()
    }
)
export default router;