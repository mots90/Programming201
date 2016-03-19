package careercup;

import java.util.*;

/**
 *
 *  Given an array of contacts with phone numbers/emails you should detect and union identical contacts.

     For example, given the following contacts array:

     [ [ "John", "john@gmail.com", "john@fb.com"],
     [ "Dan", "dan@gmail.com", "+1234567"],
     [ "john123", "+5412312", "john123@skype.com"],
     [ "john1985", "+5412312", "john@fb.com"] ]

     We can see that john1985, John and john123 are the same person by their contact information.

     We should output

     [[ 0, 2, 3], [1]] (0,2,3 are the same person and 1 is another one)

 * Created by moheet-dev on 3/13/2016.
 */
public class ContactInfoMerger {

    private Map<String, List<String>> contacts;

    private ContactInfoMerger(List<List<String>> contactInfo) {

        contacts = new HashMap<String, List<String>>();

        for (List<String> contact : contactInfo) {
            for (String info : contact) {
                if (contacts.get(info) == null)
                    contacts.put(info, contact);
                else {
                    List<String> list = contacts.get(info);
                    list.addAll(contact);
                    contacts.put(info,list);

                }

            }
        }
    }

    private void printContactInformation(String info) {

        Queue<String> queue = new PriorityQueue<String>();
        Set<String> used = new HashSet<String>();
        Set<String> gained = new HashSet<String>();


        queue.add(info);

        while (!queue.isEmpty()) {

            String key = queue.remove();
            used.add(key);
            gained.addAll(contacts.get(key));
            for (String contact : contacts.get(key)) {
                if (!used.contains(contact)) {
                    queue.add(contact);
                }
            }
        }

        System.out.println("complete info + "+gained.toString());


    }


    public static void main(String[] args) {

        List<String> john = new ArrayList<String>();
        john.add("john");
        john.add("john@gmail.com");
        john.add("john@fb.com");

        List<String> dan = new ArrayList<String>();
        dan.add("dan");
        dan.add("dan@gmail.com");
        dan.add("123123");

        List<String> john123 = new ArrayList<String>();
        john123.add("john123");
        john123.add("+5412312");
        john123.add("john123@skype.com");

        List<String> john1985 = new ArrayList<String>();
        john1985.add("john1985");
        john1985.add("+5412312");
        john1985.add("john@fb.com");

        List<List<String>> contacts = new ArrayList<List<String>>();
        contacts.add(john);
        contacts.add(dan);
        contacts.add(john123);
        contacts.add(john1985);

        ContactInfoMerger merger = new ContactInfoMerger(contacts);
        merger.printContactInformation("john");
    }

}

