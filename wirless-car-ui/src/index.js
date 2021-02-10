
import ReactDOM from 'react-dom';
import 'antd/dist/antd.css';
import './index.css';
import { Table } from 'antd';
import "./styles.css";
import React, { useState, useEffect } from 'react';

const columns = [
    {
        title: 'Customer Name',
        dataIndex: 'customerName',
        filters: [
            {
                text: 'Kalles',
                value: 'Kalles',
            },
            {
                text: 'Johans',
                value: 'Johans',
            },
            {
                text: 'Haralds',
                value: 'Haralds',
            },
        ],
        // specify the condition of filtering result
        // here is that finding the name started with `value`
        filterMultiple: false,
        onFilter: (value, record) => record.customerName.indexOf(value) === 0,
        sorter: (a, b) => a.customerName.length - b.customerName.length,
        sortDirections: ['descend'],
    },
    {
        title: 'Car-VIN',
        dataIndex: 'vin',
        defaultSortOrder: 'descend',
    },
    {
        title: 'Door Of Car',
        dataIndex: 'openDoor',
    },
    {
        title: 'Speed Of Car',
        dataIndex: 'speedKilometers',
    },
    {
        title: 'connected',
        dataIndex: 'connect',
        filters: [
            {
                text: 'connected',
                value: 'Connected',
            },
            {
                text: 'not-connected',
                value: 'Not Connected',
            },
        ],
        filterMultiple: false,
        onFilter: (value, record) => record.ping.indexOf(value) === 0,
        sorter: (a, b) => a.ping.length - b.ping.length,
        sortDirections: ['descend', 'ascend'],
    },
];

function App() {
    const [ nests, setNests ] = useState([]);
    const [ tableData, setTableData ] = useState([]);
    const [ listening, setListening ] = useState(false);
    const createCustomArr = (arr, objectItem, indexSlice) => {
        const mainArry = arr || [];
        mainArry.push(objectItem);
        const unique = [];
        mainArry.map(item => {
            if (unique.indexOf(item.vin) === -1) {
                unique.push(item)
            }
        });
       return  unique.reverse().slice(0,indexSlice)
    }
    useEffect( () => {

        if (!listening) {
        let customArr = [];
            const events = new EventSource('http://localhost:9202/api/v1/get-all-vehicle');
            events.onmessage = (event) => {
                const parsedData = JSON.parse(event.data);
                customArr = createCustomArr(nests,parsedData,7);
                setNests(customArr);
            };

            setListening(true);
        }
    }, [listening]);


    useEffect( () => {
       console.log(nests)

    }, [nests]);

    return (<Table columns={columns} dataSource={nests} pagination={false}  onChange={onChange}  backg/>);
}


function onChange(filters, sorter, extra) {
    console.log('params', filters, sorter, extra);
}

ReactDOM.render(<App />, document.getElementById('container'));