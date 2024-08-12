<template>
    <div class="card1">
        <el-card >
            <el-form label-width="80px" >
 

            <el-form-item label="姓名" style="margin-left: 200px; margin-top: -150px">
            <el-input v-model="info.name" disabled autocomplete="off" style="width: 400px"></el-input>
            </el-form-item>
   
            <el-form-item label="性别" style="margin-left: 200px">
            <el-input v-model="info.gender" disabled autocomplete="off" style="width: 400px"></el-input>
            </el-form-item>

            <el-form-item label="学号" style="margin-left: 200px">
            <el-input v-model="info.account" disabled autocomplete="off" style="width: 400px"></el-input>
            </el-form-item>

            <el-form-item label="学院" style="margin-left: 200px">
            <el-input v-model="info.depart" disabled autocomplete="off" style="width: 400px"></el-input>
            </el-form-item>

            <el-form-item label="专业" style="margin-left: 200px">
            <el-input v-model="info.major" disabled autocomplete="off" style="width: 400px"></el-input>
            </el-form-item>

            <el-form-item label="班级" style="margin-left: 200px">
            <el-input v-model="info.classNumber" disabled autocomplete="off" style="width: 400px"></el-input>
            </el-form-item>
            
</el-form>
        </el-card>
    </div>
   

</template>
<script>
import axios from 'axios';
export default{
    data(){
            return{
                info:[]
            }
        },
     created(){
            axios.get('/api/home',
            {
                headers: {
                    token:localStorage.getItem('token')
                }
            }
            )
            .then(res=>{
                this.info=res.data.data;
                console.log(res);
                console.log(this.info);
            }).catch((error)=>{
                console.log(error);
            });

        }
}
        

</script>
<style scoped>
    .card1{
        display: flex;
        justify-content: space-between;
        width: 100%;
        height: 100%;
        margin-bottom: 10px;
    }
    .el-card{
        height: 100%;
        margin: 5px;
    }
</style>