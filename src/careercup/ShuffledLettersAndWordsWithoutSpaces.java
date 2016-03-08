package careercup;

/**
 * Given a string where in each word letters were randomly shuffled and after that words were written without spaces (lets call it X).
 * Also you have a dictionary. The task is to return all possible strings S that can be transformed into the string X and all words in S are from dictionary.


 Solution:
 First, iterate over the given dictionary, sort the letters in each word, and add the sorted word and original word to a multi-map as key and value, respectively.
 This multi-map has an entry for each group of anagrams (with the sorted letters as the key for the group).

 Then, iterate on the given string, and insert each letter into a sorted array of letters. After adding a letter into the sorted array,
 check if the multimap contains the a key equal to the current value of the sorted array. If so, then we have found matching word(s),
 so we call the function recursively on the rest of the given string, and add to the count of possible strings the returned value multiplied by the number
 of words matching the key. Finally, we continue the main loop iteration to add the next letter to the sorted array.

 Example: "ymacr". We start with y, check multi-map, no match, then add m to sorted array, so we have "my" - this key exists in multimap with one word "my".
 We call recursively, with "acr" - add "a" no match, add "c" -> "ac" no match, add "r" -> "acr" this key exists in multimap with values "car",
 "arc" so we return 2. We mutiply the 1 for "my" with 2 returned in recursive call, so we add 2 to the count. Then we continue, by adding "a" -> "amy" no match,
 add "c" -> "acmy" no match, add "r" -> "acmry" no match. So final value of count is 2.


also, refer this another link : not sure if its correct: http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 *
 * Created by moheet-dev on 2/28/2016.
 */
public class ShuffledLettersAndWordsWithoutSpaces {
}
