using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading;

namespace CodeWars
{
    class Program
    {
        public static string SongDecoder(string input)
            {
                string[] words = input.Split(new string[] { "WUB" }, StringSplitOptions.None);
                string result = "";
                for (int i = 0; i < words.Length; i++)
                {
                    if (words[i] != "")
                    {
                        result += words[i];
                        result += " ";
                    }
                }
                return result.Trim();
            }
        public static string SongDecoder2(string input)
            {
                //return input.Replace("WUB","").Trim();
                return Regex.Replace(input, @"(WUB)+", " ").Trim();
            }
        public static int Persistence(long n)
        {
            short hossz = Convert.ToInt16(n.ToString().Length);
            string szam = n.ToString(); 
            int tmp, steps = 0;
            while (hossz > 1)
            {
                tmp = 1;
                foreach (char c in szam)
                {
                        tmp *= Convert.ToInt32(c.ToString());
                }
                hossz = Convert.ToInt16(tmp.ToString().Length);
                szam = tmp.ToString();
                steps++;
            }
            return Convert.ToInt32(steps);
        }
        public static int Vowels(string str)
        {
                return Regex.Replace(str, "[aeiou]", "").Length;
        }

        public static string lookSay(string num)
        {
            int mark = Convert.ToInt32(num[0].ToString());
            int count = 0;
            string result = "";
            for(int i = 0; i < num.Length; i++)
            {
                if(num[i].ToString() != mark.ToString())
                { 
                    result += count.ToString() + mark.ToString();
                    mark = Convert.ToInt32(num[i].ToString());
                    count = 1;
                } else count++;
            }
            result += count.ToString() + mark.ToString();
            return result;
        }

        public static string Longest(string s1, string s2)
        {
            string abc = "abcdefghijklmnopqrstuvwxyz";
            string result = "";
            for(int i = 0; i < abc.Length; i++)
            {
                if ((s1 + s2).Contains(abc[i].ToString()))
                {
                    result += abc[i].ToString();
                }
            }
            return result;
        }

        public static int[] MoveZeroes(int[] arr)
        {
            int[] tmp = new int[arr.Length];
            short index = 0;
            for(int i = 0; i < arr.Length; i++)
            {
                if(arr[i] != 0)
                {
                    tmp[index] = arr[i];
                    index++;
                }
            }
            for (int i = index; i < tmp.Length; i++)
                tmp[i] = 0;
            return tmp;
        }

        public static int[] MovingZeroes(int[] arr)
        {
            return arr.OrderBy(x => -x).ToArray();
        }
        public static string Like(string[] name)
        {
            switch(name.Length)
            {
                case 0: return "no one likes this";
                case 1: return name[0] + " likes this";
                case 2: return name[0] + " and " + name[1] +" like this"; 
                case 3: return name[0] + ", " + name[1] + " and " + name[2] + " like this"; 
                default: return name[0] + ", " + name[1] + " and " + (name.Length-2) + " others like this";
            }
        }

        public static int[] Sort(int[] array)
        {
            int index = 1;
            for(int i = 0;i < array.Length; i++)
            {
                if(array[i] % 2 != 0 && array[i] != 0)
                {
                    if (array[i] != index)
                    {
                        array[i] = index;
                        index += 2;
                    }
                    else index += 2;
                }
            }
            return array;
        }

        public static int[] SortEv(int[] array)
        {
            int[] tmp = new int[array.Length];
            int index = 0;
            foreach(var i in array)
            {
                if (i % 2 != 0)
                    tmp[index++] = i;                
            }           
            Array.Sort(tmp);
            index = array.Length - index;
            //index = 0;
            for (int i = 0; i < array.Length; i++)
            {
                if(array[i] % 2 != 0 && array[i] != 0)
                {
                    array[i] = tmp[index++];
                }
            }
            return array;
        }

        public static int GetUnique(IEnumerable<int> numbers)
        {
            string items = "";
            int count = 0;
            for(int i = 0; i < numbers.Count(); i++)
                    if (!items.Contains(((numbers.ToArray())[i]).ToString())) items += (numbers.ToArray())[i];

            int[,] item = new int[items.Length, 2];
            for(int i = 0; i < items.Length; i++)
            {
                for (int j = 0; j < numbers.Count(); j++)
                    if (items[i].ToString() == ((numbers.ToArray())[j]).ToString()) count++;
                
                item[i, 0] = Convert.ToInt32(items[i].ToString());
                item[i, 1] = count;
                count = 0;
            }

            int min = item[0, 1];
            int result = 0;
            for (int i = 0; i < items.Length; i++)
               if (item[i, 1] < min) min = item[i, 1];

            for (int i = 0; i < items.Length; i++)
                if (item[i, 1] == min) result = item[i, 0];

            return result;
        }

        public static int getUnique(IEnumerable<int> numbers)
        {
            var count = numbers.GroupBy(e => e).Where(e => e.Count() == 1).Select(e => e.First());
            return count.First(); 
        }


        public static int coinChallenge(int[] arr, int amount, int pos)
        {
            if (amount == 0) return 1;
            if (amount < 0) return 0;
            int result = 0;
            for(int i = pos; i < arr.Length; i++)
            {
                result += coinChallenge(arr, amount - arr[i], i);
            }
            return result;
        }

        public static string SpinWords(string sentence)
        {
            string[] words = sentence.Split(' ');
            string vowels = "aeiou";
            string result = "";
            for(int i = 0; i < words.Length; i++)
            {
                if (vowels.Contains(words[i][0].ToString()))
                {
                    for (int j = words[i].ToString().Length-1; j >= 0; j--)
                    {
                        result += words[i].ToString()[j];
                    }
                }
                else result += words[i].ToString();
                if (i < words.Length-1) result += " ";
            }
            return result;
        }

        public static string spinWords(string sentence)
        {
            string[] words = sentence.Split(' ');
            string result = "";
            for (int i = 0; i < words.Length; i++)
            {
                int hossz = words[i].ToString().Length;
                if (hossz >= 5)
                {
                    result += words[i].ToString().Reverse();
                }
                else result += words[i].ToString();
                if (i < words.Length - 1) result += " ";
            }
            return result;
        }
        static void Main(string[] args)
        {
            Console.WriteLine(spinWords("Bence egy zseniális ember"));


            //Console.WriteLine(Persistence(39));
            //Console.WriteLine("\n" + lookSay("1211")); Ez még mindig szar

            // Console.WriteLine(Vowels("Bence"));
            //Console.WriteLine(SongDecoder("RWUBWUBWUBLWUB"));
            //Console.WriteLine(SongDecoder2("RWUBWUBWUBLWUB"));
            Console.ReadKey();
        }
    }
}
