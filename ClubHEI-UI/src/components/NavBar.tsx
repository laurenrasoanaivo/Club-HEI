import React from 'react';
import logo from '../assets/Logo-HEI.png';

const NavBar: React.FC<{}> = () => {

    return (
        <div className='flex flex-row'>
            <div className='basis-1/4'>
                <img className='w-28' src={logo} alt="" />
            </div>
            <div className='flex flex-row-reverse basis-3/4 p-3'>
                <div className='mx-3'>
                    <button className='bg-slate-100 p-2 rounded-md hover:bg-slate-200'>
                        <i className="text-yellow-600/75 text-2xl fa-solid fa-people-group mr-3" />
                        Clubs
                    </button>
                </div>
                <div className='mx-3'>
                    <button className='bg-slate-100 p-2 rounded-md hover:bg-slate-200'>
                        <i className="text-yellow-600/75 text-2xl fa-solid fa-house mr-3" />
                        Home
                    </button>
                </div>
            </div>
        </div>
    )
}

export default NavBar;
