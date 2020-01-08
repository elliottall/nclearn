package tst;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    /**
     * 打印内容
     * @param index 索引
     * @param object  对象
     */

    public static void print(int index, Object object) {
        System.out.println(String.format("{%d},%s",index,object.toString()));
    }

    public static void demoOperation() {
        print(1,5+2);
        print(2,5<<2);
    }

    public static void demoString() {
        String str = "heel";
        print(1,str.indexOf('s'));
        print(2,str.charAt(1)); //ascii 编码
        print(3,str.codePointAt(1));
        print(4,str.compareToIgnoreCase("HEEL"));
        print(5,str.contains("he"));
        print(6,str.compareTo("hel"));
        print(7,str.concat("!!!"));    // 连接
        print(8,str.toUpperCase());
        print(9,str.endsWith("el"));
        print(10,str.replace('h','w'));

        StringBuilder sb = new StringBuilder(); //StringBuiler是线程不安全的，安全应该用StringBuffer
        sb.append(1.3);
        sb.append("aaa");
        sb.append(true);
        print(11,sb.toString());
    }

    public static void demoControlFlow() {
        int a = 2;
        int target = 1 == 2 ? 1 : 2;   //三目运算符
        print(1,target);
        // switch 1.8以后才支持字符串，之前支持int
        String grade = "a";
        switch (grade) {
            case "a":
                print(2,">90");
                break;
            case "b":
                print(3,">80");
                break;
            default:
                print(4,"不优秀");
                break;
        }
    }
// List的复杂度为O（n）
    public static void lstDemo(){
        List<String> strList = new ArrayList<String>();
        for(int i = 0;i < 4;i++) {
            strList.add(String.valueOf(i*i));
        }
        print(1,strList);
        List<String> strListB = new ArrayList<String>();
        for (int i = 0; i < 4;i++) {
            strListB.add(String.valueOf(i));
        }
        strList.addAll(strListB);
        print(2,strList);
        strList.remove(2);
        print(3,strList);
        strList.remove(String.valueOf(1));
        print(4,strList);
        Collections.reverse(strList);
        print(5,strList);
        Collections.sort(strList);
        print(6,strList);
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(7,strList);
        for (String obj : strList) {
            print(8,obj);
        }
    }
    //python中map为dictionary,hashtable为线程不安全，hashmap为线程安全
    public static void demoMapTable() {
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0; i < 4; i++) {
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        print(1,map);
        //迭代器
        for (Map.Entry<String,String> entry : map.entrySet()) {
            print(2,entry.getKey() + "|" + entry.getValue());
        }
        print(3,map.values());
        print(4,map.keySet());
        print(5,map.get("3"));
        print(6,map.containsKey("A"));
        map.replace("3","21");
        print(7,map.get("3"));
    }

    public static void demoSet() {
        Set<String> strSet = new HashSet<String>();
        for(int i = 0;i < 3;i++) {
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
        }
        // 集合默认是唯一的
        print(1,strSet);
        strSet.remove(String.valueOf(1));
        print(2,strSet);
        print(3,strSet.contains(String.valueOf(1)));
        print(4,strSet.isEmpty());
        strSet.addAll(Arrays.asList(new String[]{"a","b"}));
        print(5,strSet);
        for (String val : strSet) {
            print(6,val);
        }
    }

    public static void demoException() {
        try {
            int k = 2;
            if (k==2) {
                throw new Exception("i do it");
            }

        } catch (Exception e) {
            print(2,e.getMessage());
        } finally {
            // 往往用来进行垃圾回收，销毁对象等
            print(3,"finally");
        }

    }

    //面向对象例子
    public static void demo00() {
//        Animal a = new Animal("Tom",21);
//        a.say();
        Animal b = new Human("Tim", 22, "CN");
        b.say();
    }

    //方法举例
    public static void demoFunction() {
        //随机数的setSed
        Random random = new Random();
      //  random.setSeed(1);
        print(1,random.nextInt(1000));
        print(2,random.nextDouble());
       //随机打乱
        List<Integer> array = Arrays.asList(new Integer[]{1,2,3,4,5});
        Collections.shuffle(array);
        print(3,array);

        //时间:yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        print(4,date);
        print(5,date.getTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        print(6,df.format(date));

        print(7,UUID.randomUUID());
        print(8,Math.ceil(2.2));
        print(9,Math.floor(2.2));
    }
    public static void main(String[] args) {
        demoFunction();
    }
}
