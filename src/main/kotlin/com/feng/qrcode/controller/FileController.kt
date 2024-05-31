package com.feng.qrcode.controller

import cn.hutool.json.JSONObject
import com.example.entity.FileInfo
import com.feng.qrcode.utils.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
class FileController {

    @Value("\${web.filepath}")
    private val filePath: String = "/root/static/file"

    @Autowired
    lateinit  var fileUtils: FileUtils

    @RequestMapping(value = ["/"])
    fun helloWorld(request: HttpServletRequest): String {

        return "hello world!"
    }


    @RequestMapping(value = ["/file"])
    fun file(request: HttpServletRequest): MutableList<FileInfo> {
        val fileInfos = fileUtils.getFileList(filePath)
        return fileInfos
    }


    @RequestMapping(value = ["/qrcode"])
     fun getInfo(@RequestParam("url") url: String?): String? {
        val image = url?.let { fileUtils.createQRcode(it) }
        val jso = JSONObject()
        jso.putOnce("data",image)
        return jso.toString()
    }
}