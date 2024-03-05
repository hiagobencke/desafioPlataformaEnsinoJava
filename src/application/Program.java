package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Lesson> lessons = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int numLessons = sc.nextInt();
        sc.nextLine(); 
        
        for (int i = 1; i <= numLessons; i++) {
        	System.out.println();
            System.out.println("Dados da " + i + "a aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char lessonType = sc.nextLine().charAt(0);

            System.out.print("Título: ");
            String title = sc.nextLine();

            if (lessonType == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();

                System.out.print("Duração em segundos: ");
                int duration = sc.nextInt();
                sc.nextLine();

                lessons.add(new Video(title, url, duration));
            } else if (lessonType == 't') {
                System.out.print("Descrição: ");
                String description = sc.nextLine();

                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                sc.nextLine(); 

                lessons.add(new Task(title, description, questionCount));
            }
        }

        int totalDuration = calculateTotalDuration(lessons);
        System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
        sc.close();
    }

    private static int calculateTotalDuration(List<Lesson> lessons) {
        int totalDuration = 0;
        for (Lesson lesson : lessons) {
            totalDuration += lesson.duration();
        }
        return totalDuration;
    }
}
