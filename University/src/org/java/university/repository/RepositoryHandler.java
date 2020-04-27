package org.java.university.repository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import org.java.university.domain.*;

public class RepositoryHandler {
	

	private ArrayList<Student> studentList;
	private ArrayList<Professor> professorList;
	private ArrayList<Course> courseList;
	private String csvPathStudent;
	private String csvPathProfessor;
	private String csvPathCourse;
	
	public RepositoryHandler() {
	
		csvPathStudent = "C:\\Users\\usuario\\eclipse-workspace\\University\\Repository\\studentRepo.csv";
		csvPathProfessor = "C:\\Users\\usuario\\eclipse-workspace\\University\\Repository\\ProfessorRepo.csv";
		csvPathCourse = "C:\\Users\\usuario\\eclipse-workspace\\University\\Repository\\courseList.csv";
	
	}
	
	
	//This method is in charge to load the data and covert it into an array list of the students
		public ArrayList<Student> loadStudentList() {
			
			try {
				BufferedReader lineReader = new BufferedReader(new FileReader(csvPathStudent));
		        String lineText = null;
		        
		        
		        ArrayList<Student> arrStud = new ArrayList<Student>();
		        lineReader.readLine(); // skip header line

			        while ((lineText = lineReader.readLine()) != null) {
			            String[] data = lineText.split(",");
			            String name = data[0];
			            String idStudent = data[1];
			            String idCourse = data[2];
			            String age = data[3];
			            Integer ageParsed = Integer.parseInt(age);
			            Student studentPer = new Student(name, idStudent, idCourse, ageParsed);
			            
			            
			            arrStud.add(studentPer);
			            this.studentList = arrStud;

			        }lineReader.close();
	        }catch (IOException ex) {
	        	System.err.println(ex);
	        }return studentList;
			        
		}
		
		
		//This method is in charge to load the data and covert it into an array list of the professors
		public ArrayList<Professor> loadProfessorList() {
			
			try {
				BufferedReader lineReader = new BufferedReader(new FileReader(csvPathProfessor));
		        String lineText = null;
		        
		        
		        ArrayList<Professor> arrProf = new ArrayList<Professor>();
		        lineReader.readLine(); // skip header line

			        while ((lineText = lineReader.readLine()) != null) {
			            String[] data = lineText.split(",");
			            String name = data[0];
			            String idProfessor = data[1];
			            String idCourse = data[2];
			            String typeOfContract = data[3];
			            Boolean typeOf =Boolean.parseBoolean(typeOfContract);
			            String expYears = data[4];
			            Integer expYear = Integer.parseInt(expYears);
			            String salary = data[5];
			            Double salaryBase = Double.parseDouble(salary);
			            String hoursPeerWeek = data[6];
			            Integer hourPeer = Integer.parseInt(hoursPeerWeek);
			            Professor professorPer = new Professor(name, idProfessor, idCourse, typeOf, expYear, salaryBase, hourPeer);
			            
			            
			            arrProf.add(professorPer);
			            this.professorList = arrProf;

			        }lineReader.close();
	        }catch (IOException ex) {
	        	System.err.println(ex);
	        }return professorList;
			        
		}
		
		//This method is in charge to load the data and covert it into an array list of the Courses
		public ArrayList<Course> loadCourseList() {
			
			try {
				BufferedReader lineReader = new BufferedReader(new FileReader(csvPathCourse));
		        String lineText = null;
		        
		        
		        ArrayList<Course> arrCours = new ArrayList<Course>();
		        lineReader.readLine(); // skip header line

			        while ((lineText = lineReader.readLine()) != null) {
			            String[] data = lineText.split(",");
			            String name = data[0];
			            String courseRoom = data[1];
			            String idCourse = data[2];
			            Course courseEl = new Course(name, courseRoom, idCourse);
			            
			            
			            arrCours.add(courseEl);
			            this.courseList = arrCours;

			        }lineReader.close();
	        }catch (IOException ex) {
	        	System.err.println(ex);
	        }return courseList;
			        
		}
		
		//This method is created to update the array and the repository with the new information of the new students.
		public void updateStudentArray(ArrayList<Student> arrStudent) {
			
			ArrayList<Student> studentList= new ArrayList<Student>();
			studentList=arrStudent;	
			
			
			BufferedWriter lineWriter;
			try {
				lineWriter = new BufferedWriter(new FileWriter(csvPathStudent));
				
				lineWriter.write("Name,idStudent,idCourse,age");
				lineWriter.newLine();
				int i=0;
				while(i<studentList.size()) {
				
				lineWriter.write(studentList.get(i).getName()+",");
				lineWriter.write(studentList.get(i).getIdUser()+",");
				lineWriter.write(studentList.get(i).getIdCourse()+",");
				String newAge = Integer.toString(studentList.get(i).getAge()); 
				lineWriter.write(newAge);
				lineWriter.newLine();
				i++;
				}
				
				lineWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		//This method is created to update the array and the repository with the new information of the new students.
		public void updateCourseArray(ArrayList<Course> arrCourse) {
			
			ArrayList<Course> courseList= new ArrayList<Course>();
			courseList=arrCourse;
			
			BufferedWriter lineWriter;
			try {
				lineWriter = new BufferedWriter(new FileWriter(csvPathCourse));
				
				lineWriter.write("NameCourse,classRoom,idCourse");
				lineWriter.newLine();
				int i=0;
				while(i<courseList.size()) {
				
				lineWriter.write(courseList.get(i).getNameCourse()+",");
				lineWriter.write(courseList.get(i).getCourseRoom()+",");
				lineWriter.write(courseList.get(i).getIdCourse()+",");
				lineWriter.newLine();
				i++;
				}
				
				lineWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		//This method is created to update the array and the repository with the new information of the new students.
		public void updateProfessorArray(ArrayList<Professor> arrProfessors) {
			
			BufferedWriter lineWriter;
			try {
				lineWriter = new BufferedWriter(new FileWriter(csvPathProfessor));
				
				lineWriter.write("Name,idProfessor,idCourse,TypeOfCOntract,ExpYears,Salary,HoursperWeek");
				lineWriter.newLine();
				int i=0;
				while(i<arrProfessors.size()) {
				
				lineWriter.write(arrProfessors.get(i).getName()+",");
				lineWriter.write(arrProfessors.get(i).getIdUser()+",");
				lineWriter.write(arrProfessors.get(i).getIdCourse()+",");
				lineWriter.write(arrProfessors.get(i).isTypeOfContract()+",");
				lineWriter.write(arrProfessors.get(i).getExpYears()+",");
				lineWriter.write(arrProfessors.get(i).getBaseSalary()+",");
				lineWriter.write(arrProfessors.get(i).getHourPerWeek()+",");
				lineWriter.newLine();
				i++;
				}
				
				lineWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
}
