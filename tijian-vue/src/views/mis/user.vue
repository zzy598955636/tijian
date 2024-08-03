<template><div>
    <el-form :inline="true" :model="dataForm" :rules="dataRule" ref="form">
        <el-form-item prop="name">
            <el-input v-model="dataForm.name" placeholder="姓名"
                maxlength="10" class="input" clearable="clearable" />
        </el-form-item>
        <el-form-item>
            <el-select v-model="dataForm.sex" class="input" placeholder="性别"
                clearable="clearable">
                <el-option label="男" value="男" />
                <el-option label="女" value="女" />
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-select v-model="dataForm.role" class="input"
                placeholder="角色" clearable="clearable">
                <el-option v-for="one in dataForm.roleList"
                    :label="one.roleName" :value="one.roleName" />
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-select v-model="dataForm.deptId" class="input"
                placeholder="部门" clearable="clearable">
                <el-option v-for="one in dataForm.deptList"
                    :label="one.deptName" :value="one.id" />
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-select v-model="dataForm.status" class="input"
                placeholder="状态" clearable="clearable">
                <el-option label="在职" value="1" />
                <el-option label="离职" value="2" />
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="searchHandle()">查询</el-button>
            <el-button type="primary"
                :disabled="!proxy.isAuth(['ROOT', 'USER:INSERT'])"
                @click="addHandle()">
                新增
            </el-button>
            <el-button type="danger"
                :disabled="!proxy.isAuth(['ROOT', 'USER:DELETE'])"
                @click="deleteHandle()">
                批量删除
            </el-button>
        </el-form-item>
    </el-form>
</div>
</template>

<script lang="ts" setup>
    import { reactive, getCurrentInstance, ref, onMounted } from 'vue';
    const { proxy } = getCurrentInstance();
    import { dayjs } from 'element-plus';

    const dataForm = reactive({
        name: '',
        sex: '',
        role: '',
        deptId: '',
        status: '',
        roleList: [],
        deptList: []
    });
    const dataRule = reactive({
        name: [{ required: false, pattern: '^[\u4e00-\u9fa5]{1,10}$', message: '姓名格式错误' }]
    });

    function searchHandle() {
        console.log(dataForm);
    };
</script>
