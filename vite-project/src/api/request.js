import axios from 'axios';
const requests=axios.create(
    {
        baseURL:'localhost:8080',
        timeout:50000,
    }
);


  

export default requests;