class Example {

    //Определение замыкания в классе и его вызов:
    private int member = 20;
    private String method()
    {
        return "hello";
    }
    def publicMethodWithClosure(String name_)
    {
        def localVar = member + 5;
        def localVar2 = "Parameter: ${name_}";

        return {
            println "${member} ${name_} ${localVar} ${localVar2} ${method()}"
            println("\nСледующий этап, работа с файлами");
        }
    }

    public static void main(String[] args) {
        def x = 5;
        println(x);

        //Для хранения обьектов в качестве ключа можно использовать скобки ():
        def map = [(new String("username")):"james", nickname:"jcameron", (new Integer(22)):1234]
        println map.get(new Integer(22))

        //Замыкания Closures
        def c = { it, arg-> println "${it} ${arg}" }
        c.call("A", "B") // первый тип вызова
        c("C", "D") // второй тип вызова


        Example ex = new Example();
        def closureVar = ex.publicMethodWithClosure("Xavier");
        closureVar();

        //Работа с файлами
        def out= new File('File1.txt')
// если файл не существует, то создаем файл
        if(!out.exists()) {
            out.createNewFile()
            out << 'aaa\nbbb\nccc' // пишем текст в файл
        }

        List list
        list= [] // создаем список для строк
        out.eachLine { list<< it } // и заполняем его
        println (list.size() + ' - размер файла')// выводим размер списка строк
        println (out.text + '- текст в файле') // выводим весь текст
        out.write('\nnew string') // пишем текст в файл
        out.eachLine { println it}
        out.append('\nappend string') // добавляем текст в файл

//выводим информацию о файле
        println out.name
        println out.isAbsolute()
        println out.path
        println out.parent
        println out.absolutePath
        println out.absoluteFile.toString()
        println out.canonicalPath
        println out.canonicalFile.toString()
        println out.toURI().toString()

// Создаем директории
        def dir= new File('Directory1')
        dir.mkdir() //make directory, if it doesn't already exist
        def dir2= new File('Directory2/SubDir1')
        dir2.mkdirs()

        //Работа со строками
        print("\nСледующий этап, работа со строками. Было - reverse me, стало - ");
        println "reverse me".reverse()
        println "This is the end, my only friend!".tokenize(' ').reverse().join(' ')
    }
}

