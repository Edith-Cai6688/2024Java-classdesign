<script>
import CommonAside from '@/components/CommonAside.vue'
import CommonHeader from '@/components/CommonHeader.vue'
export default{
    methods:{
            back(){
            this.$router.push({path:"/login"});
            }
        },
    components:{
        CommonAside,
        CommonHeader,
    },
    provide(){
        return{
            back:this.back
        }
    }
}
</script>
<template>
    <div class="common-layout" >
    <el-container >
        <el-header class="el-header"><CommonHeader :childf="back"/></el-header>
      <el-container>
        <div class="sidebar">
            <CommonAside/>
        </div>
        <el-main class="main" style="overflow: hidden;">
            <router-view/>
        </el-main>
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
        background-color: #383973;
    }
    .main{
        background-color: #d1d2e6;
    }
   
</style>