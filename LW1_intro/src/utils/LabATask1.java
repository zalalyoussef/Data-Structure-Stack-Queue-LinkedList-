package utils;

public class LabATask1
{


    public static boolean FindBrackets(String Brackets)
    {
        ArrayStack<Character> Bstack = new ArrayStack<>();

        for (int i = 0; i < Brackets.length(); i++)
        {
            char ch = Brackets.charAt(i);

            if (ch == '[' || ch == '(' || ch == '{')
            {
                Bstack.push(ch);

            }

            if (Bstack.isEmpty())
            {
                return false;
            }

            char check;
            switch (ch)
            {
                case ')':
                    check = Bstack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = Bstack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = Bstack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (Bstack.isEmpty());
    }
}
