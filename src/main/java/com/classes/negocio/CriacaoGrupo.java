// package com.classes.negocio;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// public class CriacaoGrupo {
//     public static void main(String[] args) {
//         List<String> participants = new ArrayList<>();
//         Collections.addAll(participants, "Alex", "Elsie", "Elise", "Kimani", "Ryan", "Chris", "Paul");

//         int group = 1;
//         int membersInGroup = 0;

//         for (String participant : participants) {
//             if (membersInGroup == 3) {
//                 System.out.println("Group " + group + " consists of:");
//                 membersInGroup = 0;
//                 group++;
//             }

//             String person = participants.remove((int) (Math.random() * participants.size()));
//             System.out.println(person);
//             membersInGroup++;
//         }
//     }
// }
