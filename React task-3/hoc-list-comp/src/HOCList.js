import React,{useEffect} from 'react';

const withLogging=(WrappedComponent)=>{
    return (props)=> {
        useEffect(()=>{
            console.log('Component ${WrappedComponent.name} is mounted');
            return ()=>{
                console.log('Component ${WrappedComponent.name} is unmounted');
            };
    },[]);
    return <WrappedComponent {...props} />;
    };
};
const ProductList=({products})=>{
    return (
        <table className="table table-striped">
            <thread>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    
                </tr>
            </thread>
            <tbody>
                {products.map(product=>(
                    <tr key={product.id}>
                        <td>{product.id}</td>
                        <td>{product.name}</td>
                        <td>{product.price}</td>
                    </tr>
                ))}
                </tbody>
        </table>
        )}

const EmployeeList=({employees})=>{
    return (
        <table className="table table-striped">
            <thread>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Position</th> 
                </tr>
            </thread>
            <tbody>
                {employees.map(employee=>(
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.name}</td>
                        <td>{employee.position}</td>
                    </tr>
                ))}
                </tbody>  
               </table>
    );
};
const ProductListWithLogging=withLogging(ProductList);
const EmployeeListWithLogging=withLogging(EmployeeList);
const HOCList=()=>{
const products=[
    {id:1,name:'Laptop',price:1500},
    {id:2,name:'Mobile',price:500},
    {id:3,name:'Tablet',price:300}
];      
const employees=[
    {id:1,name:'Alex',position:'Manager'},
    {id:2,name:'John',position:'Developer'},
    {id:3,name:'David',position:'Designer'},
];
return (
    <div>
        <h2>Products List</h2>
        <ProductListWithLogging products={products} />
        <h2>Employees List</h2>
        <EmployeeListWithLogging employees={employees} />
    </div>
);
};
export default HOCList;