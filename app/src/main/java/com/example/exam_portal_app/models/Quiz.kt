package com.example.exam_portal_app.models

data class Quiz(

    var id : String = "",
    var title: String = "",
    var questions: MutableMap<String, Question> = mutableMapOf()
)
