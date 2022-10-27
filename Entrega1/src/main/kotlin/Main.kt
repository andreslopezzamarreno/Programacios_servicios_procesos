import java.io.File

fun main(){
    val file = File("Padre.kt")
    val workingDir: File = file


    println(workingDir.absolutePath)

    val pb = ProcessBuilder("java" , file.toString())

    pb.start()
}

/*
fun String.runCommand(workingDir: File? = null) {



    pb.start()


}

 */


