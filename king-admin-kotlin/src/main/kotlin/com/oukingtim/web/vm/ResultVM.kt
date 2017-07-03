package com.oukingtim.web.vm

/**
 * Created by oukingtim
 */
class ResultVM {

    var code: Int? = null

    var msg: String? = null

    var result:Any? =null

    constructor()

    constructor(code:Int,result:Any){
        this.code=code
        this.result=result
    }

    constructor(code:Int,msg: String){
        this.code=code
        this.msg=msg
    }

    constructor(code: Int){
        this.code=code
    }

    companion object {
        val CODE = 0
        fun error(): ResultVM {
            return error(500, "未知异常，请联系管理员")
        }

        fun error(msg: String): ResultVM {
            return error(500, msg)
        }

        fun error(code: Int, msg: String): ResultVM {

            return ResultVM(code, msg)
        }

        fun ok(msg: String): ResultVM {
            return ResultVM(CODE, msg)
        }

        fun ok(result: Any): ResultVM {
            return ResultVM(CODE, result)
        }

        fun ok(): ResultVM {
            return ResultVM(CODE)
        }
    }
}