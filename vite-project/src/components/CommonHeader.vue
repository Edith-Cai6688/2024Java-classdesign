<template>
    <div class="header">
        <div class="left">
            <el-icon color=white size=60px><School /></el-icon>
            <span class="title" style="color: white;font-size: 150%;">教务管理系统</span>
            <el-breadcrumb separator="/" class="bread">
                <el-breadcrumb-item :to="{ path: '/home'}" >首页</el-breadcrumb-item>
                <el-breadcrumb-item :to=breadli.path>{{breadli.name}}</el-breadcrumb-item> 
            </el-breadcrumb>
        </div>
        <el-button color="#626aef"  @click="back">退出</el-button>
    </div> 
</template>

<script>
    export default{
        
        data(){
            return{
                breadli:'/home'
            }
        },
        inject:['back'],
        watch:{
            $route(to,from){
                this.breadli=to;
        }
        
    }
}

</script>

<style>
    .header{
        display:flex;
        justify-content: space-between;
        align-items: center;
        .left{
            display: flex;
            align-items: center; 
            justify-content: center;
            span{
             margin-left: 15px;
            }
            .bread{
                .el-breadcrumb__inner{
                    color:white;
                    margin-left: 0;
                }
                .el-breadcrumb__item{
                    margin-left: 0;
                }
                .el-breadcrumb__separator{
                    margin-left: 5px;
                    margin-right: 5px;
                }
                margin-left:15px;
        }
        /* .bread{
            
        } */
    }
}
</style>