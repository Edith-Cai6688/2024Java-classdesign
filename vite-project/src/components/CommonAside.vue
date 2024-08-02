<template>
  <el-menu  background-color=#1c1d3b  text-color=white active-text-color=#87CEEB >
        <el-menu-item index="1">
          <el-icon><location /></el-icon>
          <span>系统首页</span>
        </el-menu-item>
        <el-sub-menu index="2" >
          <template #title>
            <el-icon></el-icon>
            <span>信息公告</span>
          </template >
            <el-menu-item index="2-1">教务通知</el-menu-item>
            <el-menu-item index="2-2">考试安排</el-menu-item>
            <el-menu-item index="2-3">教室安排</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <el-icon></el-icon>
            <span>行政管理</span>
          </template>
            <el-menu-item index="3-1">学院信息</el-menu-item>
            <el-menu-item index="3-2">专业信息</el-menu-item>
            <el-menu-item index="3-2">班级信息</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="4">
          <template #title>
            <el-icon></el-icon>
            <span>教学管理</span>
          </template>
            <el-menu-item index="4-1">课程信息</el-menu-item>
            <el-menu-item index="4-2">我的选课</el-menu-item>
            <el-menu-item index="4-2">我的成绩</el-menu-item>
            <el-menu-item index="4-2">网上评教</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="5">
          <template #title>
            <el-icon></el-icon>
            <span>教务管理</span>
          </template>
            <el-menu-item index="5-1">请假申请</el-menu-item>
            <el-menu-item index="5-2">作业提交</el-menu-item>
            <el-menu-item index="5-2">考勤信息</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="6">
          <template #title>
            <el-icon></el-icon>
            <span>用户管理</span>
          </template>
            <el-menu-item index="6-1">管理员信息</el-menu-item>
            <el-menu-item index="6-2">教师信息</el-menu-item>
            <el-menu-item index="6-2">学生信息</el-menu-item>
        </el-sub-menu>
      </el-menu>
</template>

<script>
    // export default:{
    //     data(){
    //         return:{
    //             [
    //                 {
    //                 path: '/home',
    //                 name: 'home',
    //                 label: '首页',
    //                 icon: 'house',
    //                 url: 'Home'
    //                 },
    //                 {
    //                     path: '/mall',
    //                     name: 'mall',
    //                     label: '商品管理',
    //                     icon: 'video-play',
    //                     url: 'Mall'
    //                 },
    //                 {
    //                     path: '/user',
    //                     name: 'user',
    //                     label: '用户管理',
    //                     icon: 'user',
    //                     url: 'User'
    //                 },
    //                 {
    //                     path: 'other',
    //                     label: '其他',
    //                     icon: 'location',
    //                     children: [
    //                         {
    //                             path: '/page1',
    //                             name: 'page1',
    //                             label: '页面1',
    //                             icon: 'setting',
    //                             url: 'Page1'
    //                         },
    //                         {
    //                             path: '/page2',
    //                             name: 'page2',
    //                             label: '页面2',
    //                             icon: 'setting',
    //                             url: 'Page2'
    //                         }
    //                     ]
    //                 }
    //         ]
    //         }
    //     }
    // }
</script>