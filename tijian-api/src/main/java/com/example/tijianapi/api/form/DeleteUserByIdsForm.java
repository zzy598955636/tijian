package com.example.tijianapi.api.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DeleteUserByIdsForm {
    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;
}


