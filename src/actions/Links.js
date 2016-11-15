import * as types from '../constants/ActionTypes'

let links = {
	 "DOMAIN" : 	"http://localhost:8080"
	//	"DOMAIN" : 	"http://125.209.200.185:8080"
}


//getMyCourses
links[types.GET_MY_LECTURES] = "/me/courses/participate";

//getProfessors
links[types.GET_PROFESSOR] = "/professor.json";

links["GET_COURSES_MORE"] = "/courses/search?instructor=$id&state=closed"

//전체 Courses
links["GET_COURSES"] = "/courses";

//특정 Course 찾기
links["GET_COURSE"] = "/courses/$id";

//Course안에서 Lecture추가
links["ADD_LECTURE"] = "/courses/$id";

//
links["GET_LECTURE"] = "/lectures/$id";


links["GET_SESSION"] = "/sessions/$id"
links["GET_DISCUSSIONS"] = "/sessions/$id/discussions"
links["GET_DISCUSSION"] = "/discusssions/$id"

links["ADD_DISCUSSION"] = "/sessions/$id/discussions"
links["GET_DISCUSSION"] = "/discussions/$id"
links["GET_PARTICIPANTS"] = "/lectures/$id/participants"

links["ADD_MY_COURSE"] = "/me/courses/participate";
links["GET_MY_COURSES"] = "/me/courses/participate"

export {links};
