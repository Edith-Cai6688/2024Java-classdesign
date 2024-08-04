<template>
    <el-dialog v-model="dialogFormVisible" title="信息" width="800" >
            <el-form :model="form" >
                <el-form-item label="标题">
                 <el-input v-model="form.title" />
                </el-form-item>
                <el-form-item label="内容" >
                 <el-input v-model="form.content" />
                </el-form-item>
            </el-form>
            <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">
                    添加
                </el-button>
            </div>
            </template>
    </el-dialog>
        <el-dialog
            v-model="dialogVisible"
            title="提示"
            width="500"
            :before-close="handleClose"
        >
            <span>你确定要删除吗？</span>
        <template #footer>
        <div class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="dialogVisible = false">
            确认
            </el-button>
        </div>
        </template>
     </el-dialog>
    <el-card>
        <el-input v-model="input" style="width: 240px" placeholder="请输入标题查询" />
        <el-button type="primary" plain style="margin-left: 15px;" @click="query">查询</el-button>
        <el-button type="info" plain @click="restart">重置</el-button>
    </el-card>      
   
    <el-card style="height: auto;">
        <el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)" :default-sort="{ property: 'number', order: 'descending' }" style="width: 100%" :cell-style="{ textAlign: 'center' }"
        :header-cell-style="{ textAlign: 'center' }">
            <el-table-column type="selection" width="55" />
            <el-table-column property="number" label="序号" sortable width="120" />
            <el-table-column property="name" label="课程名称" width="180" />
            <el-table-column property="class" label="课程类型" width="180"/>
            <el-table-column property="teacher" label="授课老师" width="120"/>
            <el-table-column property="credit" label="学分" width="120"/>
            <el-table-column property="routine" label="平时分" width="120"/>
            <el-table-column property="final" label="期末分" width="120"/>
            <el-table-column property="score" label="总分" width="120"/>
        </el-table>
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-size="pagesize"
            size="small"
            background
            layout="total,prev, pager, next"
            style="margin-top: 15px;"
            :total="tableData.length"
        />
    </el-card> 
</template>

<script>
import { ElMessage } from 'element-plus'; 
    export default{
        data(){
            return{
                input:'',
                form:{
                    title:"",
                    content:""
                },
                dialogFormVisible:false,
                dialogVisible:false,
                currentPage:1,
                pagesize:10,
                tempData:'',
                tableData:[
                {
                    number:'1',
                    name:'xxx',
                    class:'xxx',
                    teacher:'111',
                    credit:'111',
                    routine:'111',
                    final:'111',
                    score:'111'
                }
            ]
            }
        },
        methods:{
            query()
            {
                if(this.tempData!==''){
                    this.tableData=this.tempData;
                }
                if(this.input===''){
                    ElMessage.error('请重新输入');
                }else{
                    this.tempData=this.tableData;
                    this.tableData=this.tempData.filter(item=>
                        item.name.includes(this.input));
                }
            },
            restart(){
                if(this.tempData!==''){
                    this.tableData=this.tempData;
                }
            },
            handleSizeChange: function (size) {
                this.pagesize = size;
                console.log(this.pagesize)  //每页下拉显示数据
            },
            handleCurrentChange: function(currentPage){
                    this.currentPage = currentPage;
                    console.log(this.currentPage)  //点击第几页
            }},
        watch:{
                
            }
                
    }
</script>

<style>
    .el-card{
        display: flex;
        height: 50px;
        width: 100%;
        align-items: center;
        margin-bottom: 5px;
    }
</style>