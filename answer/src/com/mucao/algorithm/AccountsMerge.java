package com.mucao.algorithm;

import java.util.*;

/**
 * 题目的地址：https://leetcode.com/problems/accounts-merge/description/
 *
 *
 */
public class AccountsMerge {

    public static void main(String[] args) {
        /*
        accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
                ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
        Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
                ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
        */
       /* String[][] accounts ={{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},
                {"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},
                {"David","David1@m.co","David2@m.co"}};*/
        String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};

        List<List<String>> accounts_list = new ArrayList<>();
        for (String[] account:accounts) {
            accounts_list.add(Arrays.asList(account));
        }


        List<List<String>> result_list = accountsMerge3(accounts_list);
        System.out.println("result:  "+result_list.toString());

    }

    public static List<List<String>> accountsMerge3(List<List<String>> accounts) {
        List<List<String>> result_list = new ArrayList<>();

        //1. 先按名字进行分类
        Map<String, List<List<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            List<String> new_account = new ArrayList<>();
            for (int i = 1; i <account.size() ; i++) {
                new_account.add(account.get(i));
            }

            List<List<String>> name_accounts = map.getOrDefault(name, new LinkedList<>());
            name_accounts.add(new_account);
            map.put(name, name_accounts);
        }


        for (Map.Entry<String, List<List<String>>> entry:map.entrySet()) {
            String  name = entry.getKey();
            List<List<String>> name_accounts = entry.getValue();

            Map<String, List<Integer>> mail_indices_map = new HashMap<>();
            for (int i = 0; i < name_accounts.size(); i++) {
                List<String> name_account = name_accounts.get(i);
                for (String mail: name_account) {
                    List<Integer> indices = mail_indices_map.getOrDefault(mail, new ArrayList<>());
                    indices.add(i);
                    mail_indices_map.put(mail, indices);
                }
            }

            //检测合并
            List<List<Integer>> need_merge_list = new ArrayList<>();
            for (Map.Entry<String, List<Integer>> entry2: mail_indices_map.entrySet()) {
                List<Integer> indices = entry2.getValue();
                if(indices.size() > 1){
                    need_merge_list.add(indices);
                }
            }

            //进一步检测需要合并的列表
           /* if(need_merge_list.size() == 0){//不需要进行归并

            }else{//需要进行归并

            }*/
           if(need_merge_list.size()>0){//需要进行归并
               need_merge_list = mergeIndices(need_merge_list);//确保没有重叠项
               List<List<String>> merged_accounts = new ArrayList<>();
               Set<Integer> solved_indices = new HashSet<>();
               for (List<Integer> merge_list :need_merge_list) {
                   Set<String> set = new HashSet<>();
                   for (int index: merge_list) {
                       set.addAll(name_accounts.get(index));
                       solved_indices.add(index);
                   }
                   merged_accounts.add(new ArrayList<>(set));
               }

               //处理没有归并的
               for (int i = 0; i <name_accounts.size() ; i++) {
                   if(!solved_indices.contains(i)){
                       merged_accounts.add(name_accounts.get(i));
                   }
               }

               name_accounts = merged_accounts;
           }

           //组装结果
            for (List<String> account : name_accounts) {
               List<String> list = new ArrayList<>();
               list.add(name);
               Collections.sort(account);
               list.addAll(account);
               result_list.add(list);
            }

        }

        return result_list;
    }

    public static List<List<Integer>> mergeIndices(List<List<Integer>> need_merge_list){

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < need_merge_list.size(); i++) {
            List<Integer> list = need_merge_list.get(i);
            for (int index: list) {
                List<Integer> indices = map.getOrDefault(index, new ArrayList<>());
                indices.add(i);
                map.put(index, indices);
            }
        }

        //检测是否有重复
        List<List<Integer>> need_merge_list2 = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> indices = entry.getValue();
            if(indices.size() > 1){
                need_merge_list2.add(indices);
            }
        }

        if(need_merge_list2.size() == 0){//没有重叠项，不必要再合并了
            return need_merge_list;
        }else{//有重叠项，还是需要再合并的
            need_merge_list2 = mergeIndices(need_merge_list2);//确保处理列表中不再有重叠项了
            //进行合并
            List<List<Integer>> merged_list = new ArrayList<>();
            Set<Integer>  solved_indices = new HashSet<>();
            for (List<Integer> merge_list: need_merge_list2) {
                Set<Integer> set = new HashSet<>();
                for (int index: merge_list) {
                    set.addAll(need_merge_list.get(index));
                    solved_indices.add(index);
                }
                merged_list.add(new ArrayList<>(set));
            }

            //处理没有归并过的列表
            for (int i = 0; i < need_merge_list.size(); i++) {
                if(!solved_indices.contains(i)){
                    merged_list.add(need_merge_list.get(i));
                }
            }
            return merged_list;

        }
    }

    public static List<List<String>> accountsMerge2(List<List<String>> accounts) {
        List<List<String>> result_list = new ArrayList<>();

        //1. 先按名字进行分类
        Map<String, List<List<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            List<String> new_account = new ArrayList<>();
            for (int i = 1; i <account.size() ; i++) {
                new_account.add(account.get(i));
            }

            List<List<String>> name_accounts = map.getOrDefault(name, new LinkedList<>());
            name_accounts.add(new_account);
            map.put(name, name_accounts);
        }


        for (Map.Entry<String, List<List<String>>> entry:map.entrySet()) {
            List<List<String>> name_accounts = entry.getValue();
            String  name = entry.getKey();
//            System.out.println("name_accounts: "+name_accounts);

            Map<String, Set<String>> mail_list_map = new HashMap<>();
            for (List<String> account: name_accounts) {
                Set<String> tmp_mail_set = new HashSet<>();
                for (String mail: account) {
                    Set<String> mail_list = mail_list_map.get(mail);
                    if(mail_list == null){  //还没有
                        tmp_mail_set.add(mail);
                    }else{//已经有对应的list了
                        tmp_mail_set.addAll(mail_list);
                    }
                }
                for (String mail: tmp_mail_set) {
                    mail_list_map.put(mail, tmp_mail_set);
                }
            }

            Set<Set<String>> set = new HashSet<>(mail_list_map.values());
            for (Set<String> account: set) {
                List<String> list = new ArrayList<>();
                list.add(name);
                List<String>  account_list = new ArrayList<>(account);
                Collections.sort(account_list);
                list.addAll(account_list);
                result_list.add(new ArrayList<>(list));
            }

        }

        return result_list;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> result_list = new ArrayList<>();

        //1. 先按名字进行分类
        Map<String, List<List<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            List<String> new_account = new ArrayList<>();
            for (int i = 1; i <account.size() ; i++) {
                new_account.add(account.get(i));
            }

            List<List<String>> name_accounts = map.getOrDefault(name, new LinkedList<>());
            name_accounts.add(new_account);
            map.put(name, name_accounts);
        }

        //2. 然后进行合并
        Map<String, List<List<String>>> map2 = new HashMap<>();
        for (Map.Entry<String, List<List<String>>> entry:map.entrySet()) {
            List<List<String>> name_accounts = entry.getValue();
            String  name = entry.getKey();

            List<List<String>> new_name_accounts = new ArrayList<>();
            int cursor = 0;

            int[] merge = new int[name_accounts.size()];
            Arrays.setAll(merge, i -> i);
            Map<String, List<Integer>> mail_2_indices = new HashMap<>();

            Map<String, Integer>  mail_2_index = new HashMap<>();

            for (int i = 0; i < name_accounts.size(); i++) {
                List<String> account = name_accounts.get(i);
                for (String mail: account) {
                    List<Integer> indices = mail_2_indices.getOrDefault(mail, new ArrayList<>());
                    indices.add(i);
                    mail_2_indices.put(mail, indices);
                }
            }

            for (Map.Entry<String, List<Integer>> entry_2: mail_2_indices.entrySet()) {
                String mail = entry_2.getKey();
                List<Integer> indices = entry_2.getValue();
                if(indices.size() > 1){
                    int min_index = Integer.MAX_VALUE;
                    for (int index:indices) {
                        if(merge[index] < min_index){
                            min_index = merge[index];
                        }
                    }

                    for (int index:indices) {
                        merge[index] = min_index;
                    }
                }
            }

            for (Map.Entry<String, List<Integer>> entry_2: mail_2_indices.entrySet()) {
                String mail = entry_2.getKey();
                List<Integer> indices = entry_2.getValue();
                int index = indices.stream().map(i -> merge[i]).min(Integer::compareTo).orElse(-1);

                /*int index = Integer.MIN_VALUE;

                for (int temp: indices) {
                    if(merge[temp] < index){
                        index = merge[temp];
                    }
                }*/


                if(index > new_name_accounts.size() - 1){
                    for (int i = new_name_accounts.size(); i <= index; i++) {
                        new_name_accounts.add(new ArrayList<>());
                    }
                }

                new_name_accounts.get(index).add(mail);
            }
            map2.put(name, new_name_accounts);
        }

        //3. 拼装结果
        for (Map.Entry<String, List<List<String>>> entry:map2.entrySet()) {
            String name = entry.getKey();
            List<List<String>> name_accounts = entry.getValue();
            for (List<String> name_account : name_accounts) {
                List<String> account = new ArrayList<>();
                account.add(name);
                Collections.sort(name_account);
                account.addAll(name_account);
                if(account.size() > 1){
                    result_list.add(account);
                }
            }
        }


        return result_list;
    }
}
