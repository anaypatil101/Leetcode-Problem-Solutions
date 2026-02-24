class Solution {
    public int findContentChildren(int[] student, int[] cookie) {
        int studAssigned = 0;
       int studSize = student.length;
       int cookieSize = cookie.length;
       Arrays.sort(student);
       Arrays.sort(cookie);

       int s = 0;  //student pointer
       int c = 0;  //cookies pointer

       while(s < studSize && c < cookieSize) {
            if(cookie[c] >= student[s]) {
                //assign the cookie
                studAssigned++;
                s++;
            }
            c++;
        } 
        return studAssigned;
    }
}