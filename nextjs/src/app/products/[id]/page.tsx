// "use client";
//
// import { useParams, notFound } from "next/navigation";
// import Image from "next/image";
//
// export default function ProductDetailPage() {
//     const { id } = useParams();
//     const dummy: Record<
//         string,
//         { productName: string; description: string; imageUrl: string }
//     > = {
//         "1": {
//             productName: "플스5",
//             description: "최신형 콘솔 게임기",
//             imageUrl:
//                 "https://i.namu.wiki/i/slG6yfFwae-r-Jzq8WC59XPkHlyydYuTMwnf3UKwuwZq-4LeOXVGJWBdHTmc_TJIUgp73xoD9ivrfx93E8xj4XzqOPFtCxwJ6CT2ifqq69WXWSHbkAF4KTR2xcaCsKXHoBkf6dqUIcc0MW6jRYRVdw.webp",
//         },
//         "2": {
//             productName: "닌텐도 스위치",
//             description: "재밌는 휴대용 콘솔",
//             imageUrl:
//                 "https://i.namu.wiki/i/QcmvxVziNNazivnL1iwOAinNCAnGLfjwu84B6_JiFNuJPVt8ulnKraZdB3gsx5LC4tFuu_q5VPp9xBsAqbGodu0rR2JfhLCbOTlw4GOyVDURs2JlI0LWAQHvkQPYY88xVKXIVs_9hx8tVufOumDKlQ.webp",
//         },
//     };
//
//     const product = dummy[id as string];
//
//     if (!product) return notFound();
//
//     return (
//             <div className='mx-auto max-w-screen-2xl px-4'>
//                 <div
//                     className='flex flex-col rounded-lg border border-neutral-200 bg-white p-8 md:p-12 lg:flex-row lg:gap-8 dark:border-neutral-800 dark:bg-black'>
//                     <div className='h-full w-full basis-full lg:basis-4/6'>
//                         <form>
//                             <div className='relative aspect-square h-full max-h-[550px] w-full overflow-hidden'>
//                                 <Image
//                                     src={product.imageUrl}
//                                     alt={product.productName}
//                                     width={800}
//                                     height={600}
//                                     className="w-full h-auto object-contain"></Image>
//                             </div>
//                             <div className='absolute bottom-[15%] flex w-full justify-center'>
//                                 <div
//                                     className="mx-auto flex h-11 items-center rounded-full border border-white bg-neutral-50/80 text-neutral-500 backdrop-blur dark:border-black dark:bg-neutral-900/80">
//                                 </div>
//
//                             </div>
//
//                         </form>
//
//                         <ul className='my-12 flex items-center flex-wrap justify-center gap-2 overflow-auto py-1 lg:mb-0'>
//                             <li className='h-20 w-20 border-1 border-b-blue-700'>
//                                 <button aria-label="Select product image" className='h-full w-full text-amber-100'>
//                                     사 진 1
//                                 </button>
//                             </li>
//                             <li className='h-20 w-20 border-2 border-b-blue-700'>
//                                 <button aria-label="Select product image" className='h-full w-full text-amber-100'>
//                                     사 진 2
//                                 </button>
//                             </li>
//                             <li className='h-20 w-20 border-1 border-b-blue-700'>
//                                 <button aria-label="Select product image" className='h-full w-full text-amber-100'>
//                                     사 진 3
//                                 </button>
//                             </li>
//
//                         </ul>
//                     </div>
//                     <div className="basis-full lg:basis-2/6">
//                         <div className="mb-6 flex flex-col border-b pb-6 dark:border-neutral-700"><h1
//                             className="mb-2 text-5xl font-medium text-white">PS 4</h1>
//                             <div className="mr-auto w-auto rounded-full bg-blue-600 p-2 text-sm text-white">
//                                 <p>낙찰가 ₩200,000<span className="text-white ml-1 inline" >원</span></p></div>
//                         </div>
//                         <form>
//                             <dl className="mb-8">
//                                 <dt className="mb-4 text-sm uppercase tracking-wide text-white">Color</dt>
//                                 <dd className="flex flex-wrap gap-3">
//                                     <button aria-disabled="false" title="Color Black"
//                                             className="flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 ring-1 ring-transparent transition duration-300 ease-in-out hover:ring-blue-600"
//                                   >Black
//                                     </button>
//                                     <button aria-disabled="false" title="Color White"
//                                             className="flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 ring-1 ring-transparent transition duration-300 ease-in-out hover:ring-blue-600"
//                                   >White
//                                     </button>
//                                     <button aria-disabled="true"  title="Color Blue (Out of Stock)"
//                                             className="flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 relative z-10 cursor-not-allowed overflow-hidden bg-neutral-100 text-neutral-500 ring-1 ring-neutral-300 before:absolute before:inset-x-0 before:-z-10 before:h-px before:-rotate-45 before:bg-neutral-300 before:transition-transform dark:bg-neutral-900 dark:text-neutral-400 dark:ring-neutral-700 before:dark:bg-neutral-700"
//                                          >Blue
//                                     </button>
//                                 </dd>
//                             </dl>
//                         </form>
//                         <form>
//                             <dl className="mb-8">
//                                 <dt className="mb-4 text-sm uppercase tracking-wide text-white">경매하기 </dt>
//                                 <dd className="flex flex-wrap gap-3">
//                                     <button aria-disabled="false" title="" // 타이틀 바꿔야대
//                                             className="text-white flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 ring-1 ring-transparent transition duration-300 ease-in-out hover:ring-blue-600"
//                                     >+ 100₩
//                                     </button>
//                                     <button aria-disabled="false" title="Size S"
//                                             className="text-white flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 ring-1 ring-transparent transition duration-300 ease-in-out hover:ring-blue-600"
//                                     >+ 1,000₩
//                                     </button>
//                                     <button aria-disabled="false" title="Size S"
//                                             className="text-white flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 ring-1 ring-transparent transition duration-300 ease-in-out hover:ring-blue-600"
//                                     >+ 10,000₩
//                                     </button>
//                                     <button aria-disabled="false" title="Size S"
//                                             className="text-white flex min-w-[48px] items-center justify-center rounded-full border bg-neutral-100 px-2 py-1 text-sm dark:border-neutral-800 dark:bg-neutral-900 ring-1 ring-transparent transition duration-300 ease-in-out hover:ring-blue-600"
//                                     >+ 100,000₩
//                                     </button>
//
//                                 </dd>
//                             </dl>
//                         </form>
//                         <div
//                             className="prose mx-auto max-w-6xl  text-black prose-headings:mt-8 prose-headings:font-semibold prose-headings:tracking-wide prose-headings:text-black prose-h1:text-5xl prose-h2:text-4xl prose-h3:text-3xl prose-h4:text-2xl prose-h5:text-xl prose-h6:text-lg prose-a:text-black prose-a:underline hover:prose-a:text-neutral-300 prose-strong:text-black prose-ol:mt-8 prose-ol:list-decimal prose-ol:pl-6 prose-ul:mt-8 prose-ul:list-disc prose-ul:pl-6  dark:prose-headings:text-white dark:prose-a:text-white dark:prose-strong:text-white mb-6 text-xl leading-tight dark:text-white">
//                             남은 시간 : 10시간 : 54 분 : 21 초
//                         </div>
//
//                         <form
//
//                             action="javascript:throw new Error('A React form was unexpectedly submitted. If you called form.submit() manually, consider using form.requestSubmit() instead. If you\'re trying to use event.stopPropagation() in a submit event handler, consider also calling event.preventDefault().')">
//
//                             <button aria-label="Please select an option"
//                                     className="relative flex w-full items-center justify-center rounded-full bg-blue-600 p-4 tracking-wide text-white cursor-not-allowed opacity-60 hover:opacity-60 mt-10">
//                                 <div className="absolute left-0 ml-4">
//
//
//                                     <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
//                                          stroke-width="1.5" stroke="currentColor" aria-hidden="true" data-slot="icon"
//                                          className="h-5">
//                                         <path stroke-linecap="round" stroke-linejoin="round"
//                                               d="M12 4.5v15m7.5-7.5h-15"></path>
//                                     </svg>
//                                 </div>
//                                 낙찰하기
//
//                             </button>
//
//                             <p aria-live="polite" className="sr-only" role="status"></p></form>
//                      </div>
//                 </div>
//
//             </div>
//
//     );
// }
//

import ProductDetailPage from "./ProductDetailPage";
import { notFound } from 'next/navigation';
import React from "react";

interface Product {
    productId: number;
    productName: string;
    description: string;
    imageUrl: string;
}

interface Props {
    params: { id: string };
}

async function fetchProduct(id: string): Promise<Product | null> {

    const res = await fetch(`http://localhost:8080/products/${id}`, { cache: 'no-store' });
    console.log(res);
    // if (res.status === 404) return null;
    if (!res.ok) throw new Error('Failed to fetch product');
    return res.json();
}

export default async function ProductDetailWrapper({ params }: Props) {
    const product = await fetchProduct(params.id);

    // if (!product) notFound();


    // @ts-ignore
    return <ProductDetailPage product={product} />;
}
