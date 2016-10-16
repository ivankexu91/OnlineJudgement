/*
 ��Ŀ�� 
���������ִ�A��B����A�ִ�ת��ΪB�ִ���ת��һ�������ַ�ʽ:ɾ��������n���ַ���һ�β�������Ϊ2������������n���ַ�(���ӵ��ַ���ʲô�������)��һ�β�������Ϊn+2�����A��ΪB��С���á�

 */





import java.util.*;
		public class LeastCostToTransformStrings{
			
			public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
                while(sc.hasNext()){
                    int T = sc.nextInt();
                    sc.nextLine();
                    List<String[]> list = new ArrayList<>();
                    for(int i=0; i<T; i++){
                        String[] str = new String[2];
                        str[0] = sc.nextLine();
                        str[1] = sc.nextLine();
                        list.add(str);
                    }
                    for(String[] s:list){
                        sol(s);
                    }
                }
                sc.close();
			}
			
                
                
                private static void sol(String[] st){
                    char[] a = st[0].toCharArray();
                    char[] b = st[1].toCharArray();
                    
                    int m = a.length;
                    int n = b.length;
                    int max = n + 5;
                    
                    
                    int[][] prev = new int[n+1][4];
                    int[][] next = new int[n+1][4];
                    prev[0][0] = 0;
                    prev[0][1] = max;
                    prev[0][2] = max;
                    prev[0][3] = max;
                    
                    
                  
                    
                    for(int i=1;i<n+1;i++){
                    	
                    	prev[i][0] = max;
                    	prev[i][1] = max;
                    	prev[i][2] = i+2;
                    	prev[i][3] = max;
                    }
                    
                    for(int i=1;i<m+1;i++){
                    	
                    	next[0][0] = 2;
                    	next[0][1] = max;
                    	next[0][2] = max;
                    	next[0][3] = max;
                    	
                    	for(int j=1;j<n+1;j++){
                    		ArrayList<Integer> list4 = new ArrayList<>();
                    		int min2 = min(prev[j-1]);
                    		int min = a[i-1]==b[j-1]?min2:max;
                    		next[j][0] = min;
                    		
                    		int min3 = Math.min(prev[j][1], prev[j][0]+2);
                    		next[j][1] = min3;
                    		
                    		int min4 = Math.min(next[j-1][2]+1,next[j-1][0]+3);
                    		next[j][2] = min4;
                    		
                    		int ta = Math.min(prev[j][3], prev[j][2]+2);
                    		int tb = Math.min(next[j-1][3]+1, next[j-1][1]+3);
                    		int min5 = Math.min(ta,tb);
                    		next[j][3] = min5;
                    	}
                    	int[][] temp = prev;
                    	prev = next;
                    	next = temp;
                    }
                    
                    System.out.println(min(prev[n]));
                }
                
                private static int min(int[] list){
                	int min = Integer.MAX_VALUE;
                	for(int i:list){
                		min = Math.min(min, i);
                	}
                	return min;
                }
			}
		
                    
