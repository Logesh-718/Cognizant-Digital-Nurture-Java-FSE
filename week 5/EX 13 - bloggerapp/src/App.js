import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

    return (

        <div
            style={{
                display: "flex",
                justifyContent: "space-around"
            }}
        >

            <CourseDetails />

            <BookDetails />

            <BlogDetails />

        </div>

    );

}

export default App;