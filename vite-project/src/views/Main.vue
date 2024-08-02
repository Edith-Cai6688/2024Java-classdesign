<script>
import CommonAside from '@/components/CommonAside.vue'
export default{
    methods:{
        back(){
            this.$router.push("/login")
        }
    },
    components:{
        CommonAside
    }
}
</script>
<template>
    <div class="common-layout">
    <el-container>
      <el-header>
        <div>
            <el-icon color=white size=60px><School /></el-icon>
            <span style="color: white;font-size: 150%;">教务管理系统</span>
        </div>
        <el-button color="#626aef" :dark="isDark" @click="back()">退出</el-button>
      </el-header>
      <el-container>
        <div class="sidebar">
            <CommonAside/>
        </div>
        <el-main class="main">Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>
<style scoped lang="less">
    .common-layout{
        height:100vh;
    }
    .sidebar{
        height:100vh;
        width:180px;
        background-color: #1c1d3b;
    }
    .el-header{
        display: flex;
        background-color: #313268;   
        align-items: center; 
        justify-content:space-between;
        >div{
            display: flex;
            align-items: center; 
            span{
             margin-left: 15px;
        }
        }
    }
    .main{
        background-color: #d1d2e6;
    }
   
</style>