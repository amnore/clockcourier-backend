package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.constant.ReturnCode;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T>{
    //实现返回值的统一包装

    //处理结果状态码
    public Integer code;

    //返回结果
    public String msg;

    //返回各种类型值
    public T data;

    //构造函数
    public ResponseVO<T> code(Integer code){
        this.code=code;
        return this;
    }

    public ResponseVO<T> msg(String msg){
        this.msg=msg;
        return this;
    }

    public ResponseVO<T> data(T data){
        this.data=data;
        return this;
    }

    //static方法需要在前面额外加一个<T>,因为它不属于这个类的一部分，所以要声明为泛型方法
    public static <T> ResponseVO<T> build(){
        return new ResponseVO<>();
    }

    //成功
    public static <T> ResponseVO<T> success(){
        return ResponseVO.<T>build().code(ReturnCode.Success.getCode()).msg(ReturnMessage.Success.getMsg());
    }

    //失败
    public static <T> ResponseVO<T> failure(){
        return ResponseVO.<T>build().code(ReturnCode.Failure.getCode()).msg(ReturnMessage.Failure.getMsg());
    }



}
