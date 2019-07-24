Reference:
https://projectreactor.io/docs/core/release/reference/#faq.wrap-blocking

Use Callable to defer execution. And you should use Schedulers.elastic because it creates a dedicated thread to wait for the blocking resource without tying up some other resource.

Schedulers.immediate() : Current thread.
Schedulers.single() : A single, reusable thread.
Schedulers.newSingle() : A per-call dedicated thread.
Schedulers.elastic() : An elastic thread pool. It creates new worker pools as needed, and reuse idle ones. This is a good choice for I/O blocking work for instance.
Schedulers.parallel() : A fixed pool of workers that is tuned for parallel work.
example:

Mono.fromCallable(() -> blockingRepository.save())
        .subscribeOn(Schedulers.elastic());

        
        
        
        
        
        
        
        
https://huongdanjava.com/spring-webflux-2