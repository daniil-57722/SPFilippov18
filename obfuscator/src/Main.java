import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class Main {
    public static void main(String[] args) throws IOException {
        try {
            if (!Files.exists(Path.of("key.txt"))){
            Files.createFile(Path.of("key.txt"));}//создание файла ключа если его нет
        } catch (IOException e) {
            e.printStackTrace();
        }
        //создание объектов для трех классов
        Obfuscator obfuscator = new Obfuscator("beforeObfuscate/DownloadThread.java");
        Obfuscator obfuscator1 = new Obfuscator("beforeObfuscate/launch.java");
        Obfuscator obfuscator2 = new Obfuscator("beforeObfuscate/playmusic.java");

        //по факту это метод для выкидывания имен классов в файл ключа
        obfuscator.renameClass();
        obfuscator1.renameClass();
        obfuscator2.renameClass();
        //метод с переименованиями всего от переменных до файлов
        obfuscator.renameVariables();
        obfuscator1.renameVariables();
        obfuscator2.renameVariables();
        //исчезновение пробелов и переходов на новую строку
        obfuscator.removeSpaces();
        obfuscator1.removeSpaces();
        obfuscator2.removeSpaces();

        Files.delete(Path.of("key.txt"));//удаление файла ключа
    }
}