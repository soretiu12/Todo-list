class Task {
    String title;
    String description;
    boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addTask(String title, String description) {
        Task newTask = new Task(title, description);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String titleToMarkAsCompleted) {
        Node current = head;
        while (current != null) {
            if (current.task.title.equals(titleToMarkAsCompleted)) {
                current.task.completed = true;
                break;
            }
            current = current.next;
        }
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            System.out.println("Title: " + current.task.title);
            System.out.println("Description: " + current.task.description);
            System.out.println("Completed: " + current.task.completed);
            System.out.println();
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.addTask("Task 1", "Description 1");
        toDoList.addTask("Task 2", "Description 2");
        
        String titleToMarkAsCompleted = "Task 1";
        toDoList.markToDoAsCompleted(titleToMarkAsCompleted);

        toDoList.viewToDoList();
    }
}
