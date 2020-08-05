package com.bryant.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@SuppressWarnings ( "serial" ) //當在可序列化的類上缺少 serialVersionUID 定義時的警告，這裡是壓制警告的作用。
@NoArgsConstructor //空參構造函數
@Data //get set方法
@Accessors(chain= true ) //鏈式風格訪問，chain 若為true，則setter方法返回當前對象
public class Dept implements Serializable //必須序列化

{
    private Long deptno; //主鍵
    private String dname; //部門名稱
    private String db_source; //

}