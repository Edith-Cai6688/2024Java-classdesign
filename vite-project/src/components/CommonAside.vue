<template>
  <el-menu  background-color=#1c1d3b  text-color=white active-text-color=#87CEEB router>
        <el-menu-item index="home">
          <el-icon><House /></el-icon>
          <span>系统首页</span>
        </el-menu-item>
        <el-menu-item index="note">
          <el-icon><Notification /></el-icon>
          <span>教务通知</span>
        </el-menu-item>
        <el-sub-menu  v-for="item in li"
          :index="item.name"
          :key="item.id">
          <template #title>
            <el-icon><component :is="item.icon"/> </el-icon>
            <span>{{item.label}}</span>
          </template >
            <el-menu-item v-for="item2 in item.children" :index="item2.name" :key="item2.id">
              <el-icon>
                <component :is="item2.icon"/>          
             </el-icon>
              {{ item2.label }}
            </el-menu-item>
        </el-sub-menu>

      </el-menu>
</template>

<script>
   export default {
    data()
      {
        return{
          li:[
          {
            path:'/teach',
            name:'teach',
            label:'教学管理',
            icon:"Notebook",
            children:[
              {
                path:'/course',
                name:'course',
                label:'选课中心',
                icon:"Suitcase",
                url:'Course'
              },
              {
                path:'/mycourse',
                name:'mycourse',
                label:'我的选课',
                icon:"Document",
                url:'Mycourse'
              },
              {
                path:'/grade',
                name:'grade',
                label:'我的成绩',
                icon:"Check",
                url:'Grade'
              }
            ]
          }
        ]
        }
      }
    }
</script>