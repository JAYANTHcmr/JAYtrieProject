import java.util.*;

class Trie {
    Trie ch[];
    int wc;
    boolean ended;

    Trie() {
        ch = new Trie[26];
        wc = 0;
        ended = false;
    }
}

class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie root = new Trie();
        int ch;
        int n=sc.nextInt();
        System.out.print(
            "OPERATIONS /n 1 : Insert String /n 2 : Is String present /n 3 : autocompletion /n 4 : Get All words/n 5 : Increase no of operations by x /n/n Enter choice:");
            while(n-->0)
        {ch=sc.nextInt();
        switch (ch) {
            case 1:{
                String s=sc.next();
                insert(root,s);
            }
                break;
                case 2:
                {
                    String s=sc.next();
                    if (doesExist(root, s)) {
                        System.out.println("Exists");
                    }
    
                }  
                break;   
                case 3:
                {
                    String ps=sc.next();
                    List<String> li = new ArrayList<>();
                    getAllWords(root, ps, li);
                    for (String s : li) {
                        System.out.println(s);
                    }
    
                }     
                break;
                case 4:
                {
                List<String> li = new ArrayList<>();
                help(root, li, "");
                for (String s : li) {
                    System.out.println(s);
                }
                }    
                break;
                case 5:
                {
                    String prefix = sc.next();
                    int count = countPrefix(root, prefix);
                    System.out.println(count);
                }    
                break;
        
            default:
                break;
        }}



    }
    static void insert(Trie root,String s)
    {
        Trie te=root;
        for(char ci:s.toCharArray())
        {
            int ind=ci-'a';
            if(te.ch[ind]==null)
            {
                te.ch[ind]=new Trie();
            }
            te=te.ch[ind];
            te.wc++;
        }
        te.ended=true;
    }


    static boolean doesExist(Trie root,String s)
    {
        Trie te=root;
        for(char ci:s.toCharArray())
        {
            int ind=ci-'a';
            if(te.ch[ind]==null){
                return false;}
            te=te.ch[ind];    
        }
        return te.ended;
    }

    static void help(Trie root,List<String> li,String te)
    {
        if(root.ended)
        {
            li.add(te);
        }
        for(int i=0;i<26;i++)
        {
            if(root.ch[i]!=null)
            {
                char ch=(char)(i+'a');
                help(root.ch[i],li,te+ch);
            }
        }
    }


    static void getAllWords(Trie root, String prefix, List<String> li) {
        Trie te = root;
        for (char c : prefix.toCharArray()) {
            int ind = c - 'a';
            if (te.ch[ind] == null) {
                return; 
            }
            te = te.ch[ind];
        }
        help(te, li, prefix); 
    }

    static int countPrefix(Trie root, String prefix) {
        Trie te = root;
        for (char c : prefix.toCharArray()) {
            int ind = c - 'a';
            if (te.ch[ind] == null) {
                return 0;
            }
            te = te.ch[ind];
        }
        return te.wc;
    }


}
