package compiler_design;



import java.util.*;



class Productions{

	String left = "";

	List<String> rules = new ArrayList<>();

	Productions(String left, String[] rul){

		this.left = left.trim();

		for(int i = 0; i < rul.length; i++) {

			rules.add(rul[i].trim());

		}

	}

}

public class FnF {

	static Set<String> nT;

	static Map<String,Set<String>> fst;

	static Map<String,Set<String>> flw;

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		System.out.println("Enter no of productions:");

		int n = s.nextInt();

		System.out.println("Enter productions(@ for Expsilon):");

		s.nextLine();

		nT = new HashSet<>();

		String start = "";

		List<Productions> al = new ArrayList<>();

		for(int i = 0; i < n; i++) {

			String[] prod = s.nextLine().split("->");

			al.add(new Productions(prod[0],prod[1].split("/")));

			nT.add(prod[0].trim());

			if(i == 0) {

				start += prod[0].trim();

			}

		}

		fst = new HashMap<>();

		flw = new HashMap<>();

		for(String str : nT) {

			if(!fst.containsKey(str)) {

				first(al,str);

			}

		}

		flw.put(start, new HashSet<String>(Arrays.asList("$")));

		follow(al,start);

		for(String str : nT) {

			if(!flw.containsKey(str)) {

				follow(al,str);

			}

		}

		System.out.println("First Set:");

		for(String str:nT) {

			System.out.println(str+" "+fst.get(str));

		}

		System.out.println("Follow Set:");

		for(String str:nT) {

			System.out.println(str+" "+flw.get(str));

		}

	}



	static void first(List<Productions> al, String str) {

		Set<String> arr = new HashSet<>();

		for(int i = 0; i < al.size(); i++) {

			if(al.get(i).left.equals(str)) {

				List<String> temp = al.get(i).rules;

				for(int j = 0; j < temp.size(); j++) {

					String st = temp.get(j).charAt(0)+"";

					if(nT.contains(st)) {

						if(!fst.containsKey(st)) {

							first(al,st);

						}

						arr.addAll(fst.get(st));

					}

					else {

						arr.add(st);

					}

				}

			}

		}

		fst.put(str, arr);

	}

	static void follow(List<Productions> al, String str) {

		Set<String> arr= flw.getOrDefault(str,new HashSet<>());

		for(int i = 0; i < al.size(); i++) {

			String flt = al.get(i).left;

			List<String> temp = al.get(i).rules;

			for(int j = 0; j < temp.size(); j++) {

				if(temp.get(j).contains(str)) {

					int idx = temp.get(j).indexOf(str)+str.length();

					if(idx < temp.get(j).length()) {

						if(nT.contains(temp.get(j).charAt(idx)+"")) {

							arr.addAll(fst.get(temp.get(j).charAt(idx)+""));

						}

						else {

							arr.add((temp.get(j).charAt(idx)+""));

						}

					}

					if(!flw.containsKey(flt)) {

						follow(al,flt);

					}

					arr.addAll(flw.get(flt));

				}

			}

		}

		flw.put(str, arr);

	}

}

