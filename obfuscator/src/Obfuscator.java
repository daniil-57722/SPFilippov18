import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Obfuscator {
    public String pathToObfusc;
    public BufferedWriter bw;
    public BufferedReader br;
    public String pathAfterObfusc;

    public Obfuscator(String path) throws IOException {
        this.pathToObfusc = path;
        pathAfterObfusc = "afterObfuscate" + pathToObfusc.substring(pathToObfusc.indexOf("/"),pathToObfusc.indexOf("/")+2)+ ".java";
        br = new BufferedReader(new FileReader(pathAfterObfusc));

    }

    public void removeSpaces() throws IOException {
        //Удаление пробелов
        String line;
        String line1="";
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue; }
                line = line.trim();//уберет все пробелы перед началом
                if (line.contains("//")) {//удаление комментариев
                    line = line.substring(0, line.indexOf("//"));
                    if (line.equals("")) {
                        continue;
                    }
                }
                if (line.startsWith("@")){//добавит пробел после аннотаций, т.к. в противном случае получится @Overridepublic
                line1 += line+" ";}
                else{
                    line1 += line;
                }
            }
            br.close();//закрыли считывание
            bw = new BufferedWriter(new FileWriter(pathAfterObfusc));//открыли запись
            bw.write(line1);
            bw.flush();
            bw.close();
        }

    //переименование класса и перезапись файла
    public void renameClass() throws IOException {
        String className = pathToObfusc.substring(pathToObfusc.indexOf("/") + 1, pathToObfusc.indexOf(".java"));//получение имени класса из пути
        className = className + "#" + className.substring(0,1)+ "\n";//форматирование имени для записи в файл
        Files.write(Path.of("key.txt"),className.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);//добавление в файл
    }

    //метод волшебного изменения всех имен
    public void renameVariables() {
        try {
            String lineRenameAll = new String(Files.readAllBytes(Path.of(pathToObfusc)), StandardCharsets.UTF_8);//считываем из файла где все в 1 строку
            String lineRenameVars = lineRenameAll.substring(lineRenameAll.indexOf("class"));//срезаем часть с импортами, чтобы ничего в них не поменять

            //выражение, подходящее для поиска всех классов кроме числовых и логического. Нам подходит
            Pattern email_pattern = Pattern.compile("[A-Z]\\w*.. (\\w*)[ ;.]");

            //тут ищется соответствие найденной переменной и заменяются все её упоминания
            Matcher matcher = email_pattern.matcher(lineRenameVars);

            while (matcher.find()) {
                String str = matcher.group(1);//выборка имени переменной по регулярке
                if (str.length() > 2 && (!(str.equals("new"))&&!(str.equals("implements")))){
                    System.out.println(str);
                    str = str + "#" + str.charAt(0)+ "1" + str.substring(str.length()-1) + "\n";
                    //формат для записи в файл
                    Files.write(Path.of("key.txt"),str.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);}
            }
            String line;
            BufferedReader br = new BufferedReader(new FileReader("key.txt"));
            while ((line = br.readLine()) != null) {
                String[] mas = line.split("#");
                if (lineRenameAll.contains(mas[0])){
                    lineRenameVars = lineRenameVars.replaceAll(mas[0], mas[1]);//смена имен
                }
            }
            bw = new BufferedWriter(new FileWriter(pathAfterObfusc));
            bw.write(lineRenameAll.substring(0, lineRenameAll.indexOf("class")));//вписывание импортов
            bw.write(lineRenameVars);//вписывание всего после импортов с замененными именами
            bw.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
