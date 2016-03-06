package pt.rikmartins.clubemg.clubemgandroid.ui.publicacoes;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pt.rikmartins.clubemg.clubemgandroid.R;
import pt.rikmartins.clubemg.clubemgandroid.base.ClubeMGApplication;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.CategoriasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.EtiquetasService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.clubemg.v1.PublicacoesService;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.dagger.SimpleRestComponent;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Pagina;
import pt.rikmartins.clubemg.clubemgandroid.comunicacoes.modelos.Publicacao;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class PublicacoesAdapter extends RecyclerView.Adapter<PublicacoesAdapter.PublicacaoViewHolder> {
    public static final int TIPO_FILTRO_SEM_FILTRO = 0;
    public static final int TIPO_FILTRO_CATEGORIA = 1000;
    public static final int TIPO_FILTRO_ETIQUETA = 2000;

    private final PublicacoesService publicacoesService;
    private final CategoriasService categoriasService;
    private final EtiquetasService etiquetasService;

    private final List<Publicacao> publicacoes;

    private final Context context;
    private final int resource;
    private final int tipoFiltro;
    private final int filtro;
    private final int tamanhoPagina;

    private PublishSubject<Integer> subject;
    private Subscription subscription;

    public PublicacoesAdapter(Context context, @LayoutRes int resource, RecyclerView listaPublicacoes, LinearLayoutManager linearLayoutManager) {
        this(context, resource, listaPublicacoes, linearLayoutManager, TIPO_FILTRO_SEM_FILTRO, 0, 10);
    }

    public PublicacoesAdapter(Context context, @LayoutRes int resource, RecyclerView listaPublicacoes, LinearLayoutManager linearLayoutManager, int tipoFiltro, int filtro, int tamanhoPagina) {
        this.context = context;
        this.resource = resource;
        this.tipoFiltro = tipoFiltro;
        this.filtro = filtro;
        this.tamanhoPagina = tamanhoPagina;

        publicacoes = new ArrayList<>();

        SimpleRestComponent simpleRestComponent = ClubeMGApplication.getSimpleRestComponent(context);
        publicacoesService = simpleRestComponent.publicacoesService();
        categoriasService = simpleRestComponent.categoriasService();
        etiquetasService = simpleRestComponent.etiquetasService();

        subject = PublishSubject.create();
        subscription = subject
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer itemActual) {
                        return itemActual % PublicacoesAdapter.this.tamanhoPagina == 0;
                    }
                })
                .distinct()
                .observeOn(Schedulers.io())
                .map(new Func1<Integer, List<Publicacao>>() {
                    @Override
                    public List<Publicacao> call(Integer intComFuncao) {
                        Call<Pagina<Publicacao>> publicacoes;
                        switch (PublicacoesAdapter.this.tipoFiltro) {
                            case TIPO_FILTRO_CATEGORIA:
                                publicacoes = categoriasService.getPublicacoesCategoria(PublicacoesAdapter.this.filtro,
                                        PublicacoesAdapter.this.tamanhoPagina, intComFuncao);
                                break;
//                            case TIPO_FILTRO_ETIQUETA:
//                                // TODO: Implementar páginas no servidor e no serviço
//                                Call<List<Publicacao>> publicacoesEtiqueta = etiquetasService.getPublicacoesEtiqueta(ListaPaginavelPublicacoes.this.filtro);
//                                break;
                            default:
                                publicacoes = publicacoesService.getPublicacoes(PublicacoesAdapter.this.tamanhoPagina,
                                        intComFuncao);
                                break;
                        }
                        try {
                            Response<Pagina<Publicacao>> execute = publicacoes.execute();
                            return execute.body().getResults();
                        } catch (IOException e) {
                            // TODO: Handle this error
                            e.printStackTrace();
                            return null;
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer());

        listaPublicacoes.setAdapter(this);
        listaPublicacoes.setLayoutManager(linearLayoutManager);
        listaPublicacoes.addOnScrollListener(new PublicacoesAdapter.PublicacoesOnScrollListener(this, linearLayoutManager));

        obter(0);
    }

    protected Observer<List<Publicacao>> observer() {
        return new Observer<List<Publicacao>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Publicacao> publicacoes) {
                PublicacoesAdapter.this.publicacoes.addAll(publicacoes);
                PublicacoesAdapter.this.notifyDataSetChanged();
            }
        };
    }

    @Override
    public PublicacaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PublicacaoViewHolder(LayoutInflater.from(parent.getContext()), resource, parent);
    }

    @Override
    public void onBindViewHolder(PublicacaoViewHolder holder, int position) {
        Publicacao publicacao = publicacoes.get(position);

        holder.tituloPublicacao.setText(Html.fromHtml(publicacao.getTitulo()).toString().trim());
        holder.excertoPublicacao.setText(Html.fromHtml(publicacao.getExcerto()).toString().trim());
        Picasso.with(context).load(publicacao.getLigacaoImagem()).into(holder.imagemPublicacao);
    }

    @Override
    public int getItemCount() {
        return publicacoes != null ? publicacoes.size() : 0;
    }

    private void obter(int offset) {
        subject.onNext(offset);
    }

    public int getTipoFiltro() {
        return tipoFiltro;
    }

    public int getFiltro() {
        return filtro;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    private static class PublicacoesOnScrollListener extends RecyclerView.OnScrollListener {
        private final PublicacoesAdapter publicacoesAdapter;
        private final LinearLayoutManager linearLayoutManager;

        public PublicacoesOnScrollListener(PublicacoesAdapter publicacoesAdapter, LinearLayoutManager linearLayoutManager) {
            this.publicacoesAdapter = publicacoesAdapter;
            this.linearLayoutManager = linearLayoutManager;
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            int first = linearLayoutManager.findFirstVisibleItemPosition();


            publicacoesAdapter.obter((first / publicacoesAdapter.tamanhoPagina + 1) * publicacoesAdapter.tamanhoPagina);
        }
    }

    public static class PublicacaoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.itemPublicacao)
        RelativeLayout itemPublicacao;
        @Bind(R.id.tituloPublicacao)
        TextView tituloPublicacao;
        @Bind(R.id.excertoPublicacao)
        TextView excertoPublicacao;
        @Bind(R.id.imagemPublicacao)
        ImageView imagemPublicacao;

        public PublicacaoViewHolder(LayoutInflater inflater, @LayoutRes int resource, ViewGroup parent) {
            super(inflater.inflate(resource, parent, false));
            ButterKnife.bind(this, itemView);
        }
    }
}
