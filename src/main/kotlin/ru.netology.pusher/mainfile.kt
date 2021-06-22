package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    sendNotificationLike()
    sendNotificationNewPost()

}

fun sendNotificationLike() {
    val message = Message.builder()
            .putData("action", "LIKE")
            .putData(
                "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
            )
            .setToken(token)
            .build()


    FirebaseMessaging.getInstance().send(message)
}

fun sendNotificationNewPost() {
   val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
                "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
                "postContent": "Значимость этих проблем настолько очевидна, что консультация с широким активом играет важную роль в формировании новых предложений. Равным образом рамки и место обучения кадров влечет за собой процесс внедрения и модернизации системы обучения кадров, соответствует насущным потребностям. Товарищи! сложившаяся структура организации представляет собой интересный эксперимент проверки направлений прогрессивного развития.
"Идейные соображения высшего порядка, а также начало повседневной работы по формированию позиции позволяет оценить значение модели развития. ",

        }""".trimIndent()
        )
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
