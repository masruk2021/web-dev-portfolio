Online Course Management System (Servlet/JSP + MongoDB)

Overview
Simple OCMS implementing Admin, Teacher, and Student roles with JSP (Bootstrap), Servlets, and MongoDB.

Tech Stack
- Java 11, Servlet 4.0, JSP + JSTL
- MongoDB (mongodb-driver-sync 4.x)
- Maven, WAR packaging

Project Structure
- src/main/java/com/ocms — Java sources (models, dao, servlets, filters, config)
- src/main/webapp — JSP views and WEB-INF/web.xml

Features
- Admin: add courses, assign teachers
- Student: register for courses, view my courses
- Teacher: view assigned courses, list registered students per course
- Authentication: username/password login; session with role; AuthFilter for guards

Setup
1. Install MongoDB and start locally on mongodb://localhost:27017
2. Build: mvn clean package
3. Deploy target/ocms.war to Tomcat 9/10 (Servlet 4.0 API)
4. Visit /jsp/seed.jsp and click "Run Seeder" to create sample data
5. Login users:
   - admin/admin123 (ADMIN)
   - teacher1/teach123 (TEACHER)
   - student1/stud123 (STUDENT)

Collections and Sample Documents
- users: { _id:ObjectId, username:String, password:String, role:'ADMIN'|'TEACHER'|'STUDENT' }
- courses: { _id:ObjectId, title:String, description:String, teacherId:ObjectId|null }
- enrollments: { _id:ObjectId, studentId:ObjectId, courseId:ObjectId }

Notes
- Passwords stored in plain text for demo simplicity. Use hashing for production.
- Bootstrap loaded via CDN.
- All URLs are mapped in WEB-INF/web.xml.

References
- Servlet and JSP APIs (Oracle/EE docs)
- MongoDB Java Driver docs

