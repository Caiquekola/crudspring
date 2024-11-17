import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import { IconButton, TableContainer } from '@mui/material';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import {Paper,Box} from '@mui/material';



export default function Products() {

    const [products, setProducts] = useState(null);
    const [deletId, setDeleteId] = useState(null)
    const [confirmOpen, setConfirmOpen] = useState(null);


    const handleConfirmOpen = (id) =>{
        setDeleteId(id)
        setConfirmOpen(true)
    }
    const handleConfirmClose = (id) =>{
        setDeleteId(null)
        setConfirmOpen(false)
    }

   



    useEffect(() => {
        axios.get('http://localhost:8080/product').then(response => {
            setProducts(response.data)
            console.log(response.data)
        })
    }, []);

    return (

        <Box display="flex" justifyContent="center" alignItems="center" height="100vh">

            <TableContainer component={Paper} style={{ width: '70%' }}>
                <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">Id</TableCell>
                            <TableCell align="right">Name</TableCell>
                            <TableCell align="right">Description</TableCell>
                            <TableCell align="right">Brand</TableCell>
                            <TableCell align="right">Acquisition Date</TableCell>
                            <TableCell align="right">Price</TableCell>
                            <TableCell align="right">Actions</TableCell>


                        </TableRow>
                    </TableHead>
                    <TableBody>
                        { products !== null ? products.map((product,index)=>(
                            <TableRow 
                            key={product.id}sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                            <TableCell>
                                {product.id}
                            </TableCell>
                            <TableCell align="right">{product.name}</TableCell>
                            <TableCell align="right">{product.description}</TableCell>
                            <TableCell align="right">{product.brand}</TableCell>
                            <TableCell align="right">{product.acquisionDate}</TableCell>
                            <TableCell align="right">{product.price}</TableCell>
                            <TableCell>
                                <IconButton color='secondary' onClick={() => handleConfirmOpen(product.id)}>
                        

                                    
                                </IconButton>
                            </TableCell>
                        </TableRow>
                        )
                    ):(<div>Loading ...</div>)}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
}